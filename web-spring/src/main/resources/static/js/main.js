$(document).ready(function(){
	// Activate tooltip
	$('[data-toggle="tooltip"]').tooltip();

	// Select/Deselect checkboxes
	var checkbox = $('table tbody input[type="checkbox"]');
	$("#selectAll").click(function(){
		if(this.checked){
			checkbox.each(function(){
				this.checked = true;
			});
		} else{
			checkbox.each(function(){
				this.checked = false;
			});
		}
	});
	checkbox.click(function(){
		if(!this.checked){
			$("#selectAll").prop("checked", false);
		}
	});

	$('.edit').on('click', onEdit);
	$('.delete').on('click', onDelete);

	function onEdit(e){
	    e.preventDefault();
	    var id = $(this).data('id');
        $('#editEmployeeModal').find('input[name=id]').val(id);
	}

	function onDelete(e){
	    e.preventDefault();
	    var id = $(this).data('id');
        $('#deleteEmployeeModal').find('input[name=id]').val(id);
	}
});