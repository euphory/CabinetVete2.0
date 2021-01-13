$('document').ready(function(){
    $('.table #addButton').on('click',function(event){
        event.preventDefault();
        var href = $(this).attr('href');        
        $.get(href, function(adoptable, status){
           $('#ddlAnimalAdd').val(adoptable.animal.dateNaissance);
        });
        $('#addModal').modal();
    });
    $('table #editButton').on('click',function(event){
        event.preventDefault();
        
        var href = $(this).attr('href');
        
        $.get(href, function(adoptable, status){
           $('#idAdoptableEdit').val(adoptable.idAdoptable);
           $('#dateAbandonEdit').val(adoptable.dateAbandon); 
           $('#motifAbandonEdit').val(adoptable.motifAbandon);
        })
        $('#editModal').modal();
    });   
    $('table #detailButton').on('click',function(event){
        event.preventDefault();
        
        var href = $(this).attr('href');
        
        $.get(href, function(adoptable, status){
           $('#idAdoptableDetail').val(adoptable.idAdoptable);
           $('#dateAbandonDetail').val(adoptable.dateAbandon); 
           $('#motifAbandonDetail').val(adoptable.motifAbandon);
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


