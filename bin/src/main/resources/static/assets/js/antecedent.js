$('document').ready(function(){
    $('table #editButton').on('click',function(event){
        event.preventDefault();
        
        var href = $(this).attr('href');
        
        $.get(href, function(antecedent, status){
           $('#idAntecedentEdit').val(antecedent.idAntecedent);
           $('#ageAntecedentEdit').val(antecedent.age); 
           $('#anteceAntecedentEdit').val(antecedent.antece); 
           $('#descriptionAntecedentEdit').val(antecedent.description); 

        })
        $('#editModal').modal();
    });   
    $('table #detailsButton').on('click',function(event){
        event.preventDefault();
        
        var href = $(this).attr('href');
        
        $.get(href, function(antecedent, status){
           $('#idAntecedentDetail').val(antecedent.idAntecedent);
           $('#ageAntecedentDetail').val(antecedent.age); 
           $('#anteceAntecedentDetail').val(antecedent.antece);
           $('#descriptionAntecedentDetail').val(antecedent.description);
        });
    $('#detailsModal').modal();
    });
    
    $('table #deleteButton').on('click',function(event) {
        event.preventDefault();
        var href=$(this).attr('href');
        
        $('#confirmDeleteButton').attr('href', href);
        
        $('#deleteModal').modal();
        
    })
    
    
});
