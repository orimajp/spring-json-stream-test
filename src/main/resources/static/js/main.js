var registResult = $('#regist-result');
var normalSearchResult = $('#normal-search-result');
var streamSearchResult = $('#stream-search-result');
var dataCountResult = $('#data-count-result');

function createErrorMessage(response) {
    // 多分jquery側のエラーには対応できてない。
    return 'error=' + response.error + ' / ' + 'message=' + response.message;
}

function getEpalsedTimeMessage(start, end) {
    return '(実行時間=' + ((end - start) / 1000) + '秒)';
}

$(function () {
    $('#regist').on('click', function () {
        registResult.text('実行中...')
        var start = Date.now();
        $.post('/api/regist').done(function (data) {
            var count = data.count;
            registResult.text(count + '件登録されています。')
        }).fail(function (jqXHR, textStatus, errorThrown) {
            var response = JSON.parse(jqXHR.responseText);
            console.log(response);
            registResult.text(createErrorMessage(response));
        }).always(function () {
            var end = Date.now();
            registResult.text(registResult.text() + getEpalsedTimeMessage(start, end));
            $('#regist').blur()
        })
    });
    $('#normal-search').on('click', function () {
        normalSearchResult.text('実行中...')
        var start = Date.now();
        $.get('/api/normal').done(function (data) {
            var count = data.count;
            normalSearchResult.text(count + '件返却されました。')
        }).fail(function (jqXHR, textStatus, errorThrown) {
            var response = JSON.parse(jqXHR.responseText);
            console.log(response);
            normalSearchResult.text(createErrorMessage(response));
        }).always(function () {
            var end = Date.now();
            normalSearchResult.text(normalSearchResult.text() + getEpalsedTimeMessage(start, end));
            $('#normal-search').blur()
        })
    });
    $('#stream-search').on('click', function () {
        streamSearchResult.text('実行中...')
        var start = Date.now();
        $.get('/api/stream').done(function (data) {
            var count = data.count;
            streamSearchResult.text(count + '件返却されました。')
        }).fail(function (jqXHR, textStatus, errorThrown) {
            var response = JSON.parse(jqXHR.responseText);
            console.log(response);
            streamSearchResult.text(createErrorMessage(response));
        }).always(function () {
            var end = Date.now();
            streamSearchResult.text(streamSearchResult.text() + getEpalsedTimeMessage(start, end));
            $('#stream-search').blur()
        })
    });
    $('#data-count').on('click', function () {
        dataCountResult.text('実行中...')
        var start = Date.now();
        $.get('/api/count').done(function (data) {
            var count = data.count;
            dataCountResult.text(count + '件登録されています。')
        }).fail(function (jqXHR, textStatus, errorThrown) {
            var response = JSON.parse(jqXHR.responseText);
            console.log(response);
            dataCountResult.text(createErrorMessage(response));
        }).always(function () {
            var end = Date.now();
            dataCountResult.text(dataCountResult.text() + getEpalsedTimeMessage(start, end));
            $('#data-count').blur()
        })
    });
});
