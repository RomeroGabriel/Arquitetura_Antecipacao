<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>Solicitações de antecipação</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <script src="https://kit.fontawesome.com/923455a63a.js"></script>
</head>

<body>
  <header>
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
      <div class="container">
        <a class="navbar-brand" href="#">UTFPR</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarText"
          aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarText">
          <span class="navbar-text">
            Gerenciamento de Antecipações
          </span>
        </div>
      </div>
    </nav>
  </header>
  <div class="jumbotron jumbotron-fluid">
    <div class="container">
      <h1 class="display-4">Gerenciamento de Solicitações</h1>
      <p class="lead">Gerencie as solicitações para as antecipações de aula.</p>
    </div>
  </div>
  <div class="container">
    <h2 class="mt-5 mb-4">Nova solicitação</h2>
    <form action="/solicitation/create" method="post">
      <div class="form-group">
        <label for="motive">Motivo</label>
        <textarea value="${(currentSolicitation.motive)!}" class="form-control" id="motive" name="motive"
          rows="3"></textarea>
      </div>
      <div class="form-group">
        <label for="lessonPlan">Plano de aula</label>
        <textarea value="${(currentSolicitation.lessonPlan)!}" class="form-control" id="lessonPlan" name="lessonPlan"
          rows="3"></textarea>
      </div>
      <div class="form-group">
        <label for="anticipationId">Antecipação</label>
        <select value="${(currentSolicitation.anticipationId)!}" class="form-control" id="anticipationId"
          name="anticipationId">
          <option value="" disabled selected>Selecione</option>
          <#list anticipations as anticipation>
            <option value="${(anticipation.id)!}">${anticipation.id}</option>
          </#list>
        </select>
      </div>
      <div class="d-flex justify-content-end">
        <button type="submit" class="btn btn-dark">Criar</button>
      </div>
    </form>
  </div>
  <div class="container">
    <h2 class="mt-5 mb-4">Solicitações</h2>
    <table class="table table-hover table-stripped">
      <thead class="thead-dark">
        <tr>
          <th scope="col">ID</th>
          <th scope="col">Motivo</th>
          <th scope="col">Plano de Aula</th>
          <th scope="col">Antecipação</th>
          <th scope="col">Ações</th>
        </tr>
      </thead>
      <tbody>
        <#list solicitations as solicitation>
          <tr>
            <td scope="row">${solicitation.id}</td>
            <td>${solicitation.motive}</td>
            <td>${solicitation.lessonPlan}</td>
            <td>${solicitation.anticipation.id}</td>
            <td>
              <a href="/solicitation/consents?id=${solicitation.id} " class="btn btn-info"><i class="fas fa-paperclip"></i> Anuências</a>
              <a href="/solicitation/edit?id=${solicitation.id}" class="btn btn-secondary"><i
                  class="fas fa-pencil-alt"></i> Alterar</a>
              <a href="/solicitation/delete?id=${solicitation.id}" class="btn btn-outline-danger"><i
                  class="fas fa-trash"></i> Excluir</a>
<#--  
                  <#if solicitation.consentList?has_content>
                    <a href="${solicitation.consentList}" class="btn btn-outline-success" target="download">
                      <i class="fas fa-download"></i> download</a>
                  </#if>  -->
              
            </td>
          </tr>
        </#list>
      </tbody>
    </table>
  </div>

  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>

</html>