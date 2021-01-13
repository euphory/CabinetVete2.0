$('document').ready(function(){
    $('.table #addButton').on('click',function(event){
        event.preventDefault();
        var href = $(this).attr('href');        
        $.get(href, function(prestation, status){
           $('#ddlFormulaireAdd').val(prestation.formulaire.idFormulaire);
        });
        $('#addModal').modal();
    });
    $('table #editButton').on('click',function(event){
        event.preventDefault();
        
        var href = $(this).attr('href');
        
        $.get(href, function(prestation, status){
           $('#idPrestationEdit').val(prestation.prestationId);
           $('#quantiteUtilisePrestationEdit').val(prestation.quantiteUtilise); 
        })
        $('#editModal').modal();
    });   
    $('table #detailButton').on('click',function(event){
        event.preventDefault();
        
        var href = $(this).attr('href');
        
        $.get(href, function(prestation, status){
           $('#idPrestationDetail').val(prestation.prestationId);
           $('#quantiteUtilisePrestationDetail').val(prestation.quantiteUtilise); 
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


