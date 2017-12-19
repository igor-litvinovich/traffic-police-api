function getCookie(name) {
    return Base64.encode(localStorage.getItem('role'));
}

function getButtons(roleName, editor) {
  const role = localStorage.getItem('role');
    //TODO
    var buttons;
    if(role === 'admin') {
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
    let data = d.data[(Object.keys(d.data)[0])];
    return data;
}

function getJsonData(d) {
    return JSON.stringify(getData(d));
}