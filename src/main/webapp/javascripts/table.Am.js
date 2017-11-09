
/*
 * Editor client script for DB table Am
 * Created by http://editor.datatables.net/generator
 */

(function($){

$(document).ready(function() {
	var editor = new $.fn.dataTable.Editor( {
		ajax: 'php/table.Am.php',
		table: '#Am',
		fields: [
			{
				"label": "first:",
				"name": "first"
			},
			{
				"label": "second:",
				"name": "second"
			},
			{
				"label": "theard:",
				"name": "theard"
			}
		]
	} );

	var table = $('#Am').DataTable( {
		ajax: 'php/table.Am.php',
		columns: [
			{
				"data": "first"
			},
			{
				"data": "second"
			},
			{
				"data": "theard"
			}
		],
		select: true,
		lengthChange: false
	} );

	new $.fn.dataTable.Buttons( table, [
		{ extend: "create", editor: editor },
		{ extend: "edit",   editor: editor },
		{ extend: "remove", editor: editor }
	] );

	table.buttons().container()
		.appendTo( $('.col-sm-6:eq(0)', table.table().container() ) );
} );

}(jQuery));

