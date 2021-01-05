$('document').ready(function(){
    $('.table #addButton').on('click',function(event){
        event.preventDefault();
        var href = $(this).attr('href');        
        $.get(href, function(adoption, status){
           $('#ddlFormulaireAdd').val(adoption.formulaire.idFormulaire);
        });
        $('#addModal').modal();
    });
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
    $('table #detailButton').on('click',function(event){
        event.preventDefault();
        
        var href = $(this).attr('href');
        
        $.get(href, function(adoption, status){
           $('#idAdoptionDetail').val(adoption.idAdoption);
           $('#dateAdoptionDetail').val(adoption.dateAdoption); 
           $('#fraisAdoptionDetail').val(adoption.frais);
        })
        $('#detailModal').modal();
    });
    
    $('table #deleteButton').on('click',function(event) {
        event.preventDefault();
        var href=$(this).attr('href');
        
        $('#confirmDeleteButton').attr('href', href);
        
        $('#deleteModal').modal();
        
    })
    
    
});


