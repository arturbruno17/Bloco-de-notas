<h1 align="center">Bloco de notas</h1>
<p align="center">Aplicativo para criar anotações e tarefas</p>

<p align="center">
	<img src="https://img.shields.io/static/v1?label=room&message=2.3.0&color=2196F3&style=flat-square"/>
</p>

<p align="center">
 <a href="#-sobre">Sobre</a> •
 <a href="#-screenshots">Screenshots</a> • 
 <a href="#-bibliografia">Bibliografia</a> •
 <a href="#-contribuição">Contribuição</a>
</p>

# 📜 Sobre
Aplicativo de anotações feito com Android nativo. Possui dois componentes principais: as anotações e as tarefas e você é capaz de criar, alterar e excluir os mesmos. O projeto se baseia na arquitetura [MVVM](https://developer.android.com/jetpack/guide?gclid=CjwKCAjwoP6LBhBlEiwAvCcthA7BL-K8MS-HhYJo3KUdlEQ7KhjKFkZCKDA1uBsmR5d9xdMZtprBjxoCoZsQAvD_BwE&gclsrc=aw.ds) (Model View ViewModel) e utiliza bibliotecas do framework Android para auxiliar na implementação das funcionalidades:

* Room: biblioteca de persistência que oferece uma camada de abstração sobre o SQLite para permitir um acesso mais robusto ao banco de dados. 

Ao entrar no aplicativo, será apresentado a tela de anotações, um _floating action button_ para criar ama anotação e um _bottom navigation_ para acessar as outras telas do aplicativo. As três principais telas estão no _bottom navigation_: Favoritos, Anotações e Tarefas.

# 📱 Screenshots
<p align="center">
  <img src="https://i.ibb.co/GHXD186/Screenshot-2021-11-01-10-07-09-482-com-posart-blocodenotas.jpg" width="30%"/>
  <img src="https://i.ibb.co/QmnG0VS/Screenshot-2021-11-01-10-07-12-243-com-posart-blocodenotas.jpg" width="30%"/>
  <img src="https://i.ibb.co/BTPwsdz/Screenshot-2021-11-01-10-11-51-034-com-posart-blocodenotas.jpg" width="30%"/>
</p>

# 📚 Bibliografia
Nesta seção, você encontrará vários links e recursos que falam acerca das bibliotecas e extras utilizados no projeto.

|  Biblioteca   |  Link 	|
|---	|---	|
|   Room	|   https://developer.android.com/training/data-storage/room	|

# 🤝 Contribuição
O app foi criado e testado em um dispositivo físico, Redmi Note 9s, mas é disponível para qualquer um que queira contribuir.

Caso tenha alguma ideia de como melhorar o app, realize os seguintes passos:

1. Para contribuir, basta fazer um fork. 
(<https://github.com/arturbruno17/Bloco-de-notas/fork>)

2. Crie uma branch para sua modificação
(`git checkout -b feature/fooBar`)

3. Faça o commit
(`git commit -am "Add some fooBar"`)

4. Push
(`git push origin feature/fooBar`)

5. Crie um novo *Pull Request*
