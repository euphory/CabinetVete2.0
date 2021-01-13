$('document').ready(function(){
    $('table #editButton').on('click',function(event){
        event.preventDefault();
        
        var href = $(this).attr('href');
        
        $.get(href, function(commande, status){
           $('#idCommandeEdit').val(commande.idCommande);
           $('#referenceCommandeEdit').val(commande.reference); 
           $('#dateCommandeEdit').val(commande.dateCommande); 
           $('#totalCommandeEdit').val(commande.total); 

        })
        $('#editModal').modal();
    });   
    $('table #detailsButton').on('click',function(event){
        event.preventDefault();
        
        var href = $(this).attr('href');
        
        $.get(href, function(commande, status){
           $('#idCommandeDetail').val(commande.idCommande);
           $('#referenceCommandeDetail').val(commande.reference); 
           $('#dateCommandeDetail').val(commande.dateCommande);
           $('#totalCommandeDetail').val(commande.total);
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
