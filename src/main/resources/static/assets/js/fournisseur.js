$('document').ready(function(){
    $('table #editButton').on('click',function(event){
        event.preventDefault();
        
        var href = $(this).attr('href');
        
        $.get(href, function(fournisseur, status){
           $('#fournisseurIdEdit').val(fournisseur.fournisseurId);
           $('#nomFournisseurEdit').val(fournisseur.nom); 
           $('#adresseFournisseurEdit').val(fournisseur.adresse); 
           $('#numTVAFournisseurEdit').val(fournisseur.numTVA);           
           $('#telephoneFournisseurEdit').val(fournisseur.telephone); 
           $('#adresseMailFournisseurEdit').val(fournisseur.adresseMail);
           $('#numCompteFournisseurEdit').val(fournisseur.numCompte); 
        })
        $('#editModal').modal();
    });   
    $('table #detailsButton').on('click',function(event){
        event.preventDefault();
        
        var href = $(this).attr('href');
        
        $.get(href, function(fournisseur, status){
           $('#fournisseurIdDetail').val(fournisseur.fournisseurId);
           $('#nomFournisseurDetail').val(fournisseur.nom); 
           $('#adresseFournisseurDetail').val(fournisseur.adresse);
           $('#numTVAFournisseurDetail').val(fournisseur.numTVA);
           $('#telephoneFournisseurDetail').val(fournisseur.telephone);
           $('#adresseMailFournisseurDetail').val(fournisseur.adresseMail);
           $('#numCompteFournisseurDetail').val(fournisseur.numCompte);
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
