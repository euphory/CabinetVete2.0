$('document').ready(function(){
    $('.table #addButton').on('click',function(event){
        event.preventDefault();
        var href = $(this).attr('href');        
        $.get(href, function(espece, status){
           $('#ddlFormulaireAdd').val(espece.formulaire.idFormulaire);
        });
        $('#addModal').modal();
    });
    $('table #editButton').on('click',function(event){
        event.preventDefault();
        
        var href = $(this).attr('href');
        
        $.get(href, function(espece, status){
           $('#idEspeceEdit').val(espece.idEspece);
           $('#nomEspeceEdit').val(espece.nom); 
        })
        $('#editModal').modal();
    });   
    $('table #detailButton').on('click',function(event){
        event.preventDefault();
        
        var href = $(this).attr('href');
        
        $.get(href, function(espece, status){
           $('#idEspeceDetail').val(espece.idEspece);
           $('#nomEspeceDetail').val(espece.nom); 

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


