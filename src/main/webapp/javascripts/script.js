function getCookie(name) {
    var cookie = " " + document.cookie;
    var search = " " + name + "=";
    var setStr = null;
    var offset = 0;
    var end = 0;
    if (cookie.length > 0) {
        offset = cookie.indexOf(search);
        if (offset != -1) {
            offset += search.length;
            end = cookie.indexOf(";", offset)
            if (end == -1) {
                end = cookie.length;
            }
            setStr = unescape(cookie.substring(offset, end));
        }
    }
    return(setStr);
}

function getButtons(roleName, editor) {
    var buttons;
    if(roleName === 'admin') {
        buttons = [
            {extend: 'create', editor: editor},
            {extend: 'edit', editor: editor},
            {extend: 'remove', editor: editor},
            {
                extend: 'collection',
                text: 'Export',
                buttons: [
                    'copy',
                    'excel',
                    'csv',
                    'pdf',
                    'print'
                ]
            }
        ];
    } else{
        buttons = [
            {extend: 'create', editor: editor},
            {
                extend: 'collection',
                text: 'Export',
                buttons: [
                    'copy',
                    'excel',
                    'csv',
                    'pdf',
                    'print'
                ]
            }
        ];
    }
    return buttons;
}

function getData(d) {
    return JSON.stringify( d.data[(Object.keys(d.data)[0])] );
}