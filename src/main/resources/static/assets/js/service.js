$('document').ready(function(){
    $('table #editButton').on('click',function(event){
        event.preventDefault();
        
        var href = $(this).attr('href');
        
        $.get(href, function(service, status){
           $('#idServiceVEdit').val(service.idService);
           $('#typeServiceVEdit').val(service.type); 
        })
        $('#editModal').modal();
    });   
    $('table #detailButton').on('click',function(event){
        event.preventDefault();
        
        var href = $(this).attr('href');
        
        $.get(href, function(service, status){
           $('#idServiceVDetail').val(service.idService);
           $('#typeServiceVDetail').val(service.type); 

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


