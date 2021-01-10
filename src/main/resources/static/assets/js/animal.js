$('document').ready(function(){
    $('.table #addButton').on('click',function(event){
        event.preventDefault();
        var href = $(this).attr('href');        
        $.get(href, function(adoption, status){
           $('#ddlEspeceAdd').val(animal.espece.idEspece);
        });
        $('#addModal').modal();
    });
    $('table #editButton').on('click',function(event){
        event.preventDefault();
        
        var href = $(this).attr('href');
        
        $.get(href, function(animal, status){
           $('#idAnimalEdit').val(animal.idAnimal);
           $('#surnomAnimalEdit').val(animal.surnom); 
           $('#dateNaissanceAnimalEdit').val(animal.dateNaissance); 
           $('#poidAnimalEdit').val(animal.poid); 

        })
        $('#editModal').modal();
    });   
    $('table #detailsButton').on('click',function(event){
        event.preventDefault();
        
        var href = $(this).attr('href');
        
        $.get(href, function(animal, status){
           $('#idAnimalDetail').val(animal.idAnimal);
           $('#surnomAnimalDetail').val(animal.surnom); 
           $('#dateNaissanceAnimalDetail').val(animal.dateNaissance);
           $('#poidAnimalDetail').val(animal.poid);
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
