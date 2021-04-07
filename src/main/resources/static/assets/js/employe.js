$('document').ready(function(){
    $('table #editButton').on('click',function(event){
        event.preventDefault();
        
        var href = $(this).attr('href');
        
        $.get(href, function(employe, status){
           $('#idEmployeEdit').val(employe.idEmployeVeterinaire);
           $('#nomEmployeEdit').val(employe.nom); 
           $('#prenomEmployeEdit').val(employe.prenom);       
           $('#loginEmployeEdit').val(employe.login);                   
           $('#mdpEmployeEdit').val(employe.mdp);
           $('#adresseEmployeEdit').val(employe.adress); 
           $('#telephoneEmployeEdit').val(employe.telephone);
        })
        $('#editModal').modal();
    });   
    $('table #detailsButton').on('click',function(event){
        event.preventDefault();
        
        var href = $(this).attr('href');
        
        $.get(href, function(employe, status){
           $('#idEmployeDetail').val(employe.idEmployeVeterinaire);
           $('#nomEmployeDetail').val(employe.nom); 
           $('#prenomEmployeDetail').val(employe.prenom);       
           $('#loginEmployeDetail').val(employe.login);                   
           $('#mdpEmployeDetail').val(employe.mdp);
           $('#adresseEmployeDetail').val(employe.adress); 
           $('#telephoneEmployeDetail').val(employe.telephone);
        })
    $('#detailsModal').modal();
    });
    
    $('table #deleteButton').on('click',function(event) {
        event.preventDefault();
        var href=$(this).attr('href');
        
        $('#confirmDeleteButton').attr('href', href);
        
        $('#deleteModal').modal();
        
    })
    
    
});
