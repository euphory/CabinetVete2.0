$('document').ready(function(){
    $('.table #editButton').on('click',function(event){
        event.preventDefault();
        var href = $(this).attr('href');        
        $.get(href, function(consultation, status){
           $('#idConsultationEdit').val(consultation.idConsultation);
           $('#dateConsultationEdit').val(consultation.date); 
           $('#heureDebutConsultationEdit').val(consultation.heureDebut);
           $('#heureFinConsultationEdit').val(consultation.heureFin);
           $('#motifConsultationEdit').val(consultation.motif);
           $('#tarifGroupeConsultationEdit').val(consultation.tarifGroupe);
        });
        $('#editModal').modal();
    });
    $('.table #detailsButton').on('click',function(event){
        event.preventDefault();
        var href = $(this).attr('href');
        $.get(href, function(consultation, status){
           $('#idConsultationDetail').val(consultation.idConsultation);
           $('#dateConsultationDetail').val(consultation.date); 
           $('#heureDebutConsultationDetail').val(consultation.heureDebut);
           $('#heureFinConsultationDetail').val(consultation.heureFin);
           $('#motifConsultationDetail').val(consultation.motif);
           $('#tarifGroupeConsultationDetail').val(consultation.tarifGroupe);
        });
        $('#detailsModal').modal();
    });
    document.getElementById("aujourdhui").valueAsDate = new Date();
    $('.table #deleteButton').on('click',function(event) {
        event.preventDefault();
        var href=$(this).attr('href');
        
        $('#confirmDeleteButton').attr('href', href);
        
        $('#deleteModal').modal();
        
    });
    
    
    });

