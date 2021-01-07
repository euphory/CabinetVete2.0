$('document').ready(function(){
    $('table #editButton').on('click',function(event){
        event.preventDefault();
        
        var href = $(this).attr('href');
        
        $.get(href, function(animal, status){
           $('#idAntecedentEdit').val(animal.idAntecedent);
           $('#ageAntecedentEdit').val(animal.age); 
           $('#anteceAntecedentEdit').val(animal.antece); 
           $('#descriptionAntecedentEdit').val(animal.description); 

        })
        $('#editModal').modal();
    });   
    $('table #detailsButton').on('click',function(event){
        event.preventDefault();
        
        var href = $(this).attr('href');
        
        $.get(href, function(animal, status){
           $('#idAntecedentDetail').val(animal.idAntecedent);
           $('#ageAntecedentDetail').val(animal.age); 
           $('#anteceAntecedentDetail').val(animal.antece);
           $('#descriptionAntecedentDetail').val(animal.description);
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
