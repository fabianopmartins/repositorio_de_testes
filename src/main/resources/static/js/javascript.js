function abreFormRoleModal() {
	$.ajax({
		url : "/usuario/role/",
		success : function(data) {
			$("#formRoleModalHolder").html(data);
			$('#formRoleModal').modal({
				backdrop : 'static'
			});
		}
	});
}

function abreFormPermissaoModal() {
	$.ajax({
		url : "/usuario/permissao/",
		success : function(data) {
			$("#formPermissaoModalHolder").html(data);
			$('#formPermissaoModal').modal({
				backdrop : 'static'
			});
		}
	});
}

function abreAlteraRoleModal(id) {
	$.ajax({
		url : "/usuario/alteraRole/" + id,
		success : function(data) {
			$("#alteraRoleModalHolder").html(data);
			$('#alteraRoleModal').modal({
				backdrop : 'static'
			});
		}
	});
}

function abreAlteraPermissaoModal(id) {
	$.ajax({
		url : "/usuario/alteraPermissao/" + id,
		success : function(data) {
			$("#alteraPermissaoModalHolder").html(data);
			$('#alteraPermissaoModal').modal({
				backdrop : 'static'
			});
		}
	});
}

function abreFormAvaliacaoModal() {
	$.ajax({
		url : "/avaliacao/cadastra/",
		success : function(data) {
			$("#formAvaliacaoModalHolder").html(data);
			$('#formAvaliacaoModal').modal({
				backdrop : 'static'
			});
		}
	});
}

function abreAlteraAvaliacaoModal(id) {
	$.ajax({

		url : "/avaliacao/altera/" + id,
		success : function(data) {
			$("#alteraAvaliacaoModalHolder").html(data);
			$('#alteraAvaliacaoModal').modal({
				backdrop : 'static'
			});
		}
	});
}

function abreFormPerguntaModal() {
	$.ajax({
		url : "/pergunta/cadastra/",
		success : function(data) {
			$("#formPerguntaModalHolder").html(data);
			$('#formPerguntaModal').modal({
				backdrop : 'static'
			});
		}
	});
}

function abreAlteraPerguntaModal(id) {
	$.ajax({
		url : "/pergunta/altera/" + id,
		success : function(data) {
			$("#alteraPerguntaModalHolder").html(data);
			$('#alteraPerguntaModal').modal({
				backdrop : 'static'
			});
		}
	});
}

function abreFormUsuarioModal() {
	$.ajax({
		url : "/usuario/cadastra/",
		success : function(data) {
			$("#formUsuarioModalHolder").html(data);
			$('#formUsuarioModal').modal({
				backdrop : 'static'
			});
		}
	});
}

function abreAlteraUsuarioModal(id) {
	$.ajax({
		url : "/usuario/altera/" + id,
		success : function(data) {
			$("#alteraUsuarioModalHolder").html(data);
			$('#alteraUsuarioModal').modal({
				backdrop : 'static'
			});
		}
	});
}

function abreFormProvaModal() {
	$.ajax({
		url : "/prova/cadastra/",
		success : function(data) {
			$("#formProvaModalHolder").html(data);
			$('#formProvaModal').modal({
				backdrop : 'static'
			});
		}
	});
}

function abreAlteraProvaModal(id) {
	$.ajax({

		url : "/prova/altera/" + id,
		success : function(data) {
			$("#alteraProvaModalHolder").html(data);
			$('#alteraProvaModal').modal({
				backdrop : 'static'
			});
		}
	});
}

function abreFormRespostaModal() {
	$.ajax({
		url : "/resposta/cadastra/",
		success : function(data) {
			$("#formRespostaModalHolder").html(data);
			$('#formRespostaModal').modal({
				backdrop : 'static'
			});
		}
	});
}

function abreAlteraRespostaModal(id) {

	$.ajax({

		url : "/resposta/altera/" + id,
		success : function(data) {
			$("#alteraRespostaModalHolder").html(data);
			$('#alteraRespostaModal').modal({
				backdrop : 'static'
			});
		}
	});
}

$(document).ready(function() {
	$('h5.accordion').click(function() {
		$(this).parent().find('div.accordion1').slideToggle("slow");
	});
});