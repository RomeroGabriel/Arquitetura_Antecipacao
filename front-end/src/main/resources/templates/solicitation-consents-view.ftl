<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>Anexar lista de Anuência - Solicitações de antecipação</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <script src="https://kit.fontawesome.com/923455a63a.js"></script>
</head>
<body>
  <header>
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
      <div class="container">
        <a class="navbar-brand" href="#">UTFPR</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarText" aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
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
      <h1 class="display-4">Anexar lista de anuência</h1>
      <p class="lead">Anexe o arquivo contendo a lista de anuências.</p>
      <form method="POST" enctype="multipart/form-data" action="/solicitation/consent">
      <input type="hidden" name="id" value="${(solicitation)!}" />

      <div class="form-group">
        <input name="file" type="file" class="form-control-file" id="file">
          <div class="d-flex justify-content-end">
            <button type="submit" class="btn btn-dark">Enviar</button>
          </div>
        </div>
      <form>
    </div>
  </div>

  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>