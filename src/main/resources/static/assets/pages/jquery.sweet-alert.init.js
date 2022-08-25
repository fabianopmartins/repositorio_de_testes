
/**
* Theme: SimpleAdmin Template
* Author: Coderthemes
* SweetAlert
*/

!function ($) {
    "use strict";

    var SweetAlert = function () {
    };

    //examples
    SweetAlert.prototype.init = function () {

        //Basic
        $('#sa-basic').on('click', function () {
            swal('Qualquer tolo pode usar um computador!').catch(swal.noop)
        });

        //A title with a text under
        $('#sa-title').click(function () {
            swal(
                'A Internet ?',
                'Essa coisa ainda está por aí ?',
                'question'
            )
        });

        //Success Message
        $('#sa-success').click(function () {
            swal(
                {
                    title: 'Bom trabalho!',
                    text: 'Você clicou no botão!',
                    type: 'success',
                    confirmButtonColor: '#5862A6'
                }
            )
        });

        //Warning Message
        $('#sa-warning').click(function () {
            swal({
                title: 'Você tem certeza?',
                text: "Você não poderá reverter isso!",
                type: 'warning',
                showCancelButton: true,
                confirmButtonColor: '#5862A6',
                cancelButtonColor: '#D82E2E',
                confirmButtonText: 'Confirmar'
            }).then(function () {
                swal(
                    'Excluído!',
                    'Seu arquivo foi deletado.',
                    'success'
                )
            })
        });

        //Parameter
        $('#sa-params').click(function () {
            swal({
                title: 'Você tem certeza?',
                text: "Você não poderá reverter isso!",
                type: 'warning',
                showCancelButton: true,
                confirmButtonText: 'Confirmar',
                cancelButtonText: 'Cancelar',
            }).then(function () {
                swal(
                    'Excluído!',
                    'Seu arquivo foi deletado.',
                    'success'
                )
            }, function (dismiss) {
                // dismiss can be 'cancel', 'overlay',
                // 'close', and 'timer'
                if (dismiss === 'cancel') {
                    swal(
                        'Cancelado',
                        'Seu arquivo não foi excluído *-*',
                        'error'
                    )
                }
            })
        });

        //Custom Image
        $('#sa-image').click(function () {
            swal({
                title: 'Doce!',
                text: 'Modal com uma imagem personalizada.',
                imageUrl: 'https://unsplash.it/400/200',
                imageWidth: 400,
                imageHeight: 200,
                animation: false
            })
        });

        //Auto Close Timer
        $('#sa-close').click(function () {
            swal({
                title: 'Alerta de fechamento automático!',
                text: 'Vou fechar em 2 segundos.',
                timer: 2000
            }).then(
                function () {
                },
                // handling the promise rejection
                function (dismiss) {
                    if (dismiss === 'timer') {
                        console.log('I was closed by the timer')
                    }
                }
            )
        });

        //custom html alert
        $('#custom-html-alert').click(function () {
            swal({
                title: '<i>HTML</i> <u>exemplo</u>',
                type: 'info',
                html: 'Você pode usar <b>texto em negrito</b>, ' +
                '<a href="//coderthemes.com/">ligações</a> ' +
                'e outras tags HTML',
                showCloseButton: true,
                showCancelButton: true,
                confirmButtonText: '<i class="fa fa-thumbs-up"></i>',
                cancelButtonText: '<i class="fa fa-thumbs-down"></i>'
            })
        });

        //Custom width padding
        $('#custom-padding-width-alert').click(function () {
            swal({
                title: 'Largura personalizada, preenchimento, plano de fundo.',
                width: 600,
                padding: 100,
                background: '#fff url(//subtlepatterns2015.subtlepatterns.netdna-cdn.com/patterns/geometry.png)'
            })
        });

        //Ajax
        $('#ajax-alert').click(function () {
            swal({
                title: 'Enviar email para executar a solicitação ajax',
                input: 'email',
                showCancelButton: true,
                confirmButtonText: 'Enviar',
                showLoaderOnConfirm: true,
                preConfirm: function (email) {
                    return new Promise(function (resolve, reject) {
                        setTimeout(function () {
                            if (email === 'taken@example.com') {
                                reject('Este e-mail já está tomado.')
                            } else {
                                resolve()
                            }
                        }, 2000)
                    })
                },
                allowOutsideClick: false
            }).then(function (email) {
                swal({
                    type: 'success',
                    title: 'Solicitação Ajax concluída!',
                    html: 'Email enviado: ' + email
                })
            })
        });

        //chaining modal alert
        $('#chaining-alert').click(function () {
            swal.setDefaults({
                input: 'text',
                confirmButtonText: 'Próximo',
                showCancelButton: true,
                animation: false,
                progressSteps: ['1', '2', '3']
            })

            var steps = [
                {
                    title: 'Questão 1',
                    text: 'O encadeamento dos modais swal2 é fácil'
                },
                'Questão 2',
                'Questão 3'
            ]

            swal.queue(steps).then(function (result) {
                swal.resetDefaults()
                swal({
                    title: 'Tudo feito!',
                    html: 'Suas respostas: <pre>' +
                    JSON.stringify(result) +
                    '</pre>',
                    confirmButtonText: 'Encantador',
                    showCancelButton: false
                })
            }, function () {
                swal.resetDefaults()
            })
        });

        //Danger
        $('#dynamic-alert').click(function () {
            swal.queue([{
                title: 'Seu IP público',
                confirmButtonText: 'Mostrar meu IP público',
                text: 'Seu IP público será recebido ' +
                'via solicitação AJAX',
                showLoaderOnConfirm: true,
                preConfirm: function () {
                    return new Promise(function (resolve) {
                        $.get('https://api.ipify.org?format=json')
                            .done(function (data) {
                                swal.insertQueueStep(data.ip)
                                resolve()
                            })
                    })
                }
            }])
        });


    },
        //init
        $.SweetAlert = new SweetAlert, $.SweetAlert.Constructor = SweetAlert
}(window.jQuery),

//initializing
    function ($) {
        "use strict";
        $.SweetAlert.init()
    }(window.jQuery);