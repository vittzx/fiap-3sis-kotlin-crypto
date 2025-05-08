# Checkpoint - Android Kotlin Development

Explicando o código feito em aula pelo professor Ewerton Carreira pela turma 3SIS-fiap 2025.

Direitos Autorais do README de Vitor Cosso - RM 98231


## Main Activity -> onCreate

Quando o método na MainActicity.kt `onCreate(savedInstanceState: Bundle?)` é executado implicitamente quando a activity é inicializada, ele realiza a chamada de 4 outras funcoes e uma delas mais de uma vez:

- `super.onCreate(savedInstanceState)` -> responsável pela implementação completa do onCreate, fazendo a preparacao do ciclo de vida, lida com a restauracao do estado, garante que componentes do framework sejam corretamente configurados.

- `findViewById(R.id.[id_da_view])` -> localiza a view pelo id dentro da pasta Res

- `configureToolBarMain(toolbar: Toolbar)` -> realiza a configuração da tela e, dentro do método toolbar é configurado o título, a cor do título,o background, e faz a chamada do setSupportActionBar
  OBS: Os detalhes como a mensagem do título,a sua cor e outros detalhes, tambem são extraidas da pasta res/values do arquivo string.xml e colors.xml

- dentro do `btnRefreshButton.setOnClickListener{ makeCallRequest() }` -> faz a chamada da requisição para retornar o valor do bitcoin e todas as ações estão dentro desse método makeCallRequest

Direitos Autorais do README de Vitor Cosso - RM 98231

## Main Activity -> makeCallRequest()


- Inicializa o service com `MercadoBitcoinServiceFactory` que é Design Pattern que tem como objetivo a construição dinamica de uma classe na qual seu nome é designida, como aqui é o `MercadoBitcoinService`. Ela é inicializada com a função  `create()`

- Após inicializar a função `create()` no service, o service faz a chamada da função `getTicker()`, que é responsável pela chamada GET HTTP RESTFULL para o endpoint que retorna um objeto do tipo `Response<TickerResponse>` que será armazenado na variável resposne.

- Após realizar a chamada http, para o endpoint, ele fará a verificação do response se a chamada é sucesso, // code 2XX

- Entretanto, se for sucesso, ele pega o atributo lastValue do body tickerResponse e verifica se ele não é nulo. Se ele não for nulo, é exibido na propriedade lblValue dentro do seu texto (.text). A atualização do lblDate.text é realizada atraves do sfd.format(formato da data, LocalDate.getDefault())

- Após isso, a tela exibe a data e hora e o valor do bitcoin.

- Caso a operação de erro, ela é tratada com erros 400, 401, 403 e 404 ou Unkown error;

Direitos Autorais do README de Vitor Cosso - RM 98231


## MercadoBitcoinService -> getTicker()

- Faz a chamama via interface implementada pela dependencia Retrofit, presente dentro do `build.gradle.kts` pelo método e annotation GET, dentro dele indicando o endpoint `api/BTC/ticker/`. O Atributo `suspend` indica que é uma chamada asisncrona, para não bloquear a a funcionalidade thread se a chamada demorar. Essa função retorna uma Response do tipo TickerResponse, sendo ela mapeada a resposta JSON e fazendo a conversão para a classe

Direitos Autorais do README de Vitor Cosso - RM 98231


## MercadoBitcoinServiceFactory -> create()

- Seguindo o Design Pattern Factory de criação de objetos e classes dinamicamente,a classe `MercadoBitcoinServiceFactory` é responsável por criar e configurar uma instância do serviço Retrofit para se comunicar com a API do Mercado Bitcoin. Ela define a URL base da API e registra o conversor Gson para transformar JSON em objetos Kotlin automaticamente. O método create() retorna uma implementação da interface MercadoBitcoinService pronta para uso em chamadas HTTP

## Tela

![image](https://github.com/user-attachments/assets/1f6eb5dc-1b0f-4066-80fb-ed55b5c43e7f)


Direitos Autorais do README de Vitor Cosso - RM 98231
