$('document').ready(function(){
    $('.table #editButton').on('click',function(event){
        event.preventDefault();
        var href = $(this).attr('href');        
        $.get(href, function(formulaire, status){
           $('#idFormulaireEdit').val(formulaire.idFormulaire);
           $('#dateFormulaireEdit').val(formulaire.dateFormulaire); 
           $('#raisonFormulaireEdit').val(formulaire.raison);
        });
        $('#editModal').modal();
    });
    $('.table #detailsButton').on('click',function(event){
        event.preventDefault();
        var href = $(this).attr('href');
        $.get(href, function(formulaire, status){
           $('#idFormulaireDetail').val(formulaire.idFormulaire);
           $('#idAdoptionDetail').val(formulaire.adoption.idAdoption);
           $('#dateFormulaireDetail').val(formulaire.dateFormulaire); 
           $('#raisonFormulaireDetail').val(formulaire.raison);
           $('#dateAdoptionDetail').val(formulaire.adoption.dateAdoption); 
           $('#fraisAdoptionDetail').val(formulaire.adoption.frais);
        });
        $('#detailsModal').modal();
    });
    $('.table #deleteButton').on('click',function(event) {
        event.preventDefault();
        var href=$(this).attr('href');
        
        $('#confirmDeleteButton').attr('href', href);
        
        $('#deleteModal').modal();
        
    });
    
    
});

