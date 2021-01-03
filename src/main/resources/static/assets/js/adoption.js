$('document').ready(function(){
    $('table #editButton').on('click',function(event){
        event.preventDefault();
        
        var href = $(this).attr('href');
        
        $.get(href, function(adoption, status){
           $('#idAdoptionEdit').val(adoption.idAdoption);
           $('#dateAdoptionEdit').val(adoption.dateAdoption); 
           $('#fraisAdoptionEdit').val(adoption.frais);
        })
        $('#editModal').modal();
    });
    $('table #deleteButton').on('click',function(event) {
        event.preventDefault();
        var href=$(this).attr('href');
        
        $('#confirmDeleteButton').attr('href', href);
        
        $('#deleteModal').modal();
        
    })
    
    
});


