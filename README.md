# このプロジェクトについて
REST APIサーバにおいて、大容量のJsonレスポンス返却に対するSteeamを利用した実装方法の調査を行う。

# 利用技術
* Spiing Booot 2.1
* MySQL 5.7
* Doma
* Lombok
* ModelMapper

# 実行環境構築
## テストDB準備
1. テストスキーマ作成
2. `craate.sql`実行

## 起動設定
1. プロジェクトチェックアウト
2. `application.properties`にてDB接続設定を実施

## 注意事項
テストデータ登録処理で使っているバッチインサートに対応していない環境の場合、処理の修正が必要になる可能性がある。

# 提供機能
## テストデータ登録
テストデータを10万件登録。追加登録可能。

## 通常検索
エンティティリストを返却するDomaメソッドを使った検索を行い、`RestController`にて検索結果を基に生成したクラスのインスタンスを`ResponseEntity`として返却。

## ストリーム検索
Functionをパラメータとして持つDomaメソッドを使ったStream検索とクラス生成および、`JsonGenerator`によるJson生成を行い、`ResponseEntity<StreamingResponseBody>`として返却。

## 登録データ件数取得
データ件数を返却。

# 実行手順
1. アプリ起動
2. テストデータ投入
3. 検索実施

# 結果概要
手元の環境(iMac 5K 2015 Core i 7)にて、10万件と20万件についてテストを実施。

## 時間
何れの検索方法においても10万件で25秒前後、20万件で50秒前後時が掛かる。ストリーム検索では何れの件数でも2秒ほど余計に時間が掛かっていたが、何らかのオーバヘッドがあるのかも知れない。

## GC
VisualVMのGCアクティビティを見る限り、通常検索では必ずGCが発生するが、ストリーム検索では発生しないように見える。

## DB接続
検索が終わるとDomaメソッドが終了する通常検索に対し、ストリーム検索は全てのJson処理が終わるまで(?)Domaメソッドが終わらないように見える。DBに繋がりっぱなしだとすると、監視サービスにてスロークエリとして扱われたり、DB接続数の制限に引っかかってしまう可能性が考えられる。

## エラー通知
ストリーム検索では実行中にエラーが発生しても空のJsonが返り、クライアントにエラー発生を通知できないように見える。

# ストリーム検索におけるエラー
ストリーム検索テストにて実行時間が30秒を超えたところでエラー発生。

```
2019-11-03 08:15:47.369 ERROR 70602 --- [nio-8080-exec-7] o.a.catalina.connector.CoyoteAdapter     : Exception while processing an asynchronous request

java.lang.IllegalStateException: Calling [asyncError()] is not valid for a request with Async state [MUST_DISPATCH]
省略

Encountered a non-recycled response and recycled it forcedly.

org.apache.catalina.connector.CoyoteAdapter$RecycleRequiredException: null
省略
```

このエラーは非同期処理のタイムアウトによるものなので、`applicatoon.properties`にて`spring.mvc.async.request-timeout`を使って延長することにより対応可能。

# 備考
非同期処理は古いTomcatのバグを踏む可能性がありそう。

* https://stackoverflow.com/questions/53639444/tomcat7-is-not-waiting-for-async-requests-to-complete-their-work-on-shutdown
* https://bz.apache.org/bugzilla/show_bug.cgi?id=63003
