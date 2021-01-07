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
           $('#idEspeceEdit').val(adoption.idEspece);
           $('#nomEspeceEdit').val(adoption.nom); 
        })
        $('#editModal').modal();
    });   
    $('table #detailButton').on('click',function(event){
        event.preventDefault();
        
        var href = $(this).attr('href');
        
        $.get(href, function(adoption, status){
           $('#idEspeceDetail').val(adoption.idEspece);
           $('#nomEspeceDetail').val(adoption.nom); 

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


