$('document').ready(function(){
    $('table #editButton').on('click',function(event){
        event.preventDefault();
        
        var href = $(this).attr('href');
        
        $.get(href, function(personne, status){
           $('#idPersonneEdit').val(personne.idPersonne);
           $('#nomPersonneEdit').val(personne.nom); 
           $('#prenomPersonneEdit').val(personne.prenom); 
           $('#adressePersonneEdit').val(personne.adresse); 
           $('#adresseMailPersonneEdit').val(personne.adresseMail); 
           $('#numAssurancePersonneEdit').val(personne.numAssurance);
           $('#telephonePersonneEdit').val(personne.telephone);
        })
        $('#editModal').modal();
    });   
    $('table #detailsButton').on('click',function(event){
        event.preventDefault();
        
        var href = $(this).attr('href');
        
        $.get(href, function(personne, status){
           $('#idPersonneDetail').val(personne.idPersonne);
           $('#nomPersonneDetail').val(personne.nom); 
           $('#prenomPersonneDetail').val(personne.prenom); 
           $('#adressePersonneDetail').val(personne.adresse); 
           $('#adresseMailPersonneDetail').val(personne.adresseMail); 
           $('#numAssurancePersonneDetail').val(personne.numAssurance);
           $('#telephonePersonneDetail').val(personne.telephone);
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
