package storage;

import model.Question;

public class Storage {
    public static final int PULOS = 1;
    public static final int TIPS = 2;
    static final String[][] ALTERNATIVES = {
        {
            "a) conjunto de animais de uma área.",
            "b) conjunto de vertebrados de uma área.",
            "c) conjunto de plantas de uma área.",
            "d) conjunto de protozoários de uma área.",
            "e) conjunto de invertebrados de uma área."

        },
        {
            "a) A flora é afetada por fatores como temperatura e regime de chuvas.",
            "b) Quando observamos a flora do Brasil, percebemos que as mesmas espécies ocorrem em todo o território nacional.",
            "c) A flora do Brasil apresenta uma grande quantidade de espécies endêmicas.",
            "d) Algumas espécies da flora brasileira não são encontradas em nenhum lugar do mundo.",
            "e) A flora de uma região apresenta adaptações para sobreviver em uma área, como é o caso do cacto, que armazena água."

        },
        {
            "a) ao conjunto de animais aquáticos de uma região.",
            "b) ao conjunto de obras que descrevem protozoários de uma região.",
            "c) ao conjunto de micro-organismos encontrados em nosso corpo.",
            "d) ao conjunto de espécies de animais endêmicas de uma área.",
            "e) ao conjunto de organismos invasores de uma área."
        },
        {
            "a) O termo “flora” é usado para nomear obras que descrevem plantas de uma área.",
            "b) O termo “flora” é utilizado para indicar a diversidade vegetal de uma área.",
            "c) O termo “flora” é usado para indicar o conjunto de micro-organismos em nosso corpo.",
            "d) O termo “flora” é usado para indicar a diversidade de animais de uma área."
        },
        {
            "A. Mata Atlântica.",
            "B. Pantanal.",
            "C. Amazônia.",
            "D. Caatinga.",
            "E. Pampas."
        },
        {
            "A. taxa reprodutiva líquida elevada e ausência de competidores fortes.",
            "B. crescimento populacional exponencial e capacidade de dispersão alta.",
            "C. natalidade elevada e alta resistência à invasão.",
            "D. capacidade de suporte elevada e área ampla.",
            "E. baixa resiliência e nichos ecológicos numerosos."
        },
        {
            "A. Amazônia, Cerrado e Manguezal.",
            "B. Amazônia, Caatinga e Cerrado.",
            "C. Amazônia, Cerrado e Restinga.",
            "D. Caatinga, Cerrado e Manguezal.",
            "E. Caatinga, Cerrado e Restinga."
        },
        {
            "A. A caatinga é constituída por árvores baixas, arbustos com poucas folhas, cactáceas e bromeliáceas.",
            "B. Os pampas, vegetação característica do estado do Paraná, são predominantemente formados por pinheiros do gênero Araucaria.",
            "C. A floresta amazônica é uma região cuja vegetação é característica de ambientes costeiros, com predominância de cactáceas.",
            "D. Formação arbórea aberta com vegetação herbácea abundante e presença de árvores geralmente pequenas com tronco retorcido e de casca grossa são características predominantes da caatinga.",
            "E. A mata atlântica possui vegetação com arbustos de pequeno porte de poucas folhas e com muitas gramíneas."
        },
        {
            "A. A Mata Atlântica é caracterizada por formação vegetal de porte baixo e baixa diversidade de espécies, podendo apresentar diversos estágios sucessivos e vários estratos, com presença de serapilheira, cipós, epífitas e trepadeiras.",
            "B. O manguezal é uma faixa estreita paralela ao litoral, de vegetação exuberante e com grande diversidade de espécies arbóreas, como pau-brasil, guapuruvu e o cambuci.",
            "C. A caatinga apresenta uma grande riqueza de ambientes, vegetação do tipo savana estépica, e espécies que não são encontradas em nenhum outro bioma, denominadas espécies endêmicas.",
            "D. Na Bahia, as principais ameaças à biodiversidade do cerrado são os solos secos e de baixa fertilidade, com altos níveis de ferro e alumínio."
        },
        {
            "A. A Amazônia é o maior bioma do Brasil, em contrapartida apresenta uma diversidade biológica reduzida devido à crescente urbanização.",
            "B. O Pantanal é um bioma representado como uma planície inundável e no Brasil está presente nos estados de Mato Grosso e Goiás.",
            "C. O Pantanal é caracterizado por áreas inundáveis, sua vegetação é diversificada e pode variar nas áreas alagadas, as periodicamente alagadas e as que não são alagadas.",
            "D. O Cerrado apresenta espécies de plantas lenhosas que desenvolveram estruturas adaptativas para a sobrevivência nas suas condições ambientais, tais como casca fina sem sulcos, caules retilíneos e raízes aéreas"
        },
        {
            "A. à profundidade do solo e à pouca quantidade de nutrientes nele existente.",
            "B. às estações do ano bem definidas, sendo seca e chuvosa.",
            "C. à estrutura das árvores que possuem folhas rígidas e troncos retorcidos.",
            "D. às atividades humanas ligadas à agricultura e à pecuária."
        },
        {
            "A. a jaguatirica (Leopardus Pardalis).",
            "B. o jaú (Paulicea luetkeni).",
            "C. a seriema (Cariama cristata).",
            "D. o buriti (Mauritia flexuosa)."
        },
        {
            "A. O solo do Cerrado é normalmente mais pobre que o circundante, no caso da Mata Atlântica e da Amazônia, e sua vegetação é, em geral, de pequeno porte, com galhos retorcidos, casca e folhas grossas, capazes de melhor resistir a incêndios recorrentes.",
            "B. O Cerrado é constituído por várias características de vegetação, e pode ser classificado em subsistemas: de campo, de cerrado, de cerradão, de matas, de matas ciliares e de veredas em ambientes alagadiços.",
            "C. Como o solo é mais rico em nutrientes, a Caatinga apresenta uma grande riqueza de ambientes e espécies onde a seca, a luminosidade e o calor resultam numa vegetação xerófita espinhosa e decidual.",
            "D. A Mata Atlântica tem como principal tipo de vegetação a floresta ombrófila densa, normalmente relacionada a um clima normalmente quente e úmido, enquanto o Pampa é marcado por clima chuvoso, sem período seco regular e com frentes polares e temperaturas negativas no inverno.",
            "E. A condição latifoliada da Amazônia se deve à grande facilidade de transpiração e captação de luz pelas folhas, além de solo mais rico em nutrientes do que os outros biomas brasileiros."
        },
        {
            "A. A vegetação é composta por plantas xerófitas que se adaptaram em um ambiente com poucas chuvas e baixa umidade. No bioma são comuns árvores baixas e arbustos, e a presença de espinhos em muitas espécies vegetais reduz a perda de água pela transpiração.",
            "B. A Caatinga está localizada em uma região com clima semiárido com árvores que, em geral, não perdem as folhas na estação das secas (espécies caducifólias).",
            "C. O bioma tem sido desmatado de forma acelerada, devido ao consumo de lenha nativa, explorada de forma ilegal e insustentável para fins domésticos e indústrias, ao sobrepastoreio e a conversão para pastagens e agricultura.",
            "D. Um estudo realizado pelo IBAMA determinou os três principais ecótonos no Brasil: o Cerrado-Amazônia, o Caatinga-Amazônia e o Cerrado-Caatinga.",
            "E. A Caatinga está localizada em uma região com clima semiárido com árvores que, em geral, perdem as folhas na estação das secas."
        },
        {
            "A. teoria amazônica e ecologia de populações.",
            "B. teoria evolutiva e geografia de populações.",
            "C. teoria dispersiva e ocupação ambiental.",
            "D. teoria sintética da evolução e ecologia evolutiva.",
            "E. teoria dos refúgios e biogeografia."
        },
        {
            "A. mata dos cocais.",
            "B. veredas.",
            "C. cerrado.",
            "D. mata atlântica.",
            "E. carrasco."
        },
        {
            "A. o pampa.",
            "B. o pantanal.",
            "C. a caatinga.",
            "D. a floresta amazônica.",
            "E. a mata atlântica."
        },
        {
            "A. caracteriza-se, em termos de clima, por duas estações bem definidas, uma bastante seca e outra bastante chuvosa.",
            "B. é uma floresta tropical fechada, cujo solo não muito rico possui apenas uma fina camada de nutrientes.",
            "C. é também denominada de savana brasileira.",
            "D. caracteriza-se por períodos de seca, sendo composta por campos cobertos predominantemente por gramíneas.",
            "E. abrange a costa leste, sudeste e sul do Brasil."
        },
        {
            "A. hábitat.",
            "B. nicho ecológico.",
            "C. biocenose.",
            "D. ecossistema.",
            "E. biótopo."
        },
        {
            "A. é o bioma que apresenta a maior preservação no estado, principalmente na região serrana.",
            "B. junto é o bioma que apresenta a maior preservação no estado, principalmente na região serrana.",
            "C. originalmente é o único bioma continental presente em toda a extensão territorial do estado.",
            "D. junto com os biomas restinga, manguezais e dunas compõe a fitofisionomia do estado.",
            "E. é o bioma mais ameaçado do estado em função de sua distribuição se restringir às regiões serranas."
        },
        {
            "A. é o bioma que apresenta a maior preservação no estado, principalmente na região serrana.",
            "B. junto é o bioma que apresenta a maior preservação no estado, principalmente na região serrana.",
            "C. originalmente é o único bioma continental presente em toda a extensão territorial do estado.",
            "D. junto com os biomas restinga, manguezais e dunas compõe a fitofisionomia do estado.",
            "E. é o bioma mais ameaçado do estado em função de sua distribuição se restringir às regiões serranas."
        },
    };
    public static final Question[] QUESTIONS = {
        new Question(
                "Quando falamos da flora de uma região, estamos referindo-nos ao",
                ALTERNATIVES[0],
                Question.Alternative.C,
                100,
                "Dica 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1"
        ),
        new Question(
                "O termo “flora” é bastante conhecido de todos e refere-se à diversidade vegetal. Sobre o tema, marque a alternativa incorreta.",
                ALTERNATIVES[1],
                Question.Alternative.B,
                500,
                " Dica 2 Dica 2 Dica 2 Dica 2"
        ),
        new Question(
                "Quando falamos em flora, normalmente, estamos referindo-nos à diversidade de plantas de uma área. Entretanto, o termo “flora” pode ser usado em outros casos, como para se referir:",
                ALTERNATIVES[2],
                Question.Alternative.C,
                700,
                "Dica 3"
        ),
        new Question(
                "O termo “flora” pode ser utilizado em diferentes casos. Analise as afirmações abaixo e marque aquela que não indica um uso correto para esse termo.",
                ALTERNATIVES[3],
                Question.Alternative.D,
                500,
                "Dica 4"
        ),
        new Question(
                "Segundo o IBGE, o Brasil possui seis grandes biomas, que abrigam uma das maiores biodiversidades do planeta. Entre esses biomas, inclui-se o bioma influenciado pelo clima subtropical e pela formação do relevo, de clima frio e seco, cuja vegetação é constituída principalmente por gramíneas. Tal bioma denomina-se",
                ALTERNATIVES[4],
                Question.Alternative.E,
                1000,
                "Dica 5"
        ),
        new Question(
                "Em uma comunidade biótica, a dominância de uma espécie exótica invasora resulta tanto de atributos de sua população como do ambiente, exemplificados, respectivamente, por",
                ALTERNATIVES[5],
                Question.Alternative.A,
                800,
                "Dica 6"
        ),
        new Question(
                "Os três biomas que ocorrem no Estado do Maranhão, e que estão representados no Parque Nacional dos Lençóis Maranhenses, são:",
                ALTERNATIVES[6],
                Question.Alternative.B,
                700,
                "Dica 7"
        ),
        new Question(
                "Assinale a alternativa correta",
                ALTERNATIVES[7],
                Question.Alternative.A,
                800,
                "Dica 8"
        ),
        new Question(
                "Assinale a alternativa correta",
                ALTERNATIVES[8],
                Question.Alternative.C,
                900,
                "Dica 9"
        ),
        new Question(
                "Um bioma é um conjunto de tipos de vegetação que abrange grandes áreas contínuas, em escala regional, com flora e fauna similares, definidas pelas condições físicas predominantes nas regiões. Esses aspectos climáticos, geográficos e litológicos, por exemplo, fazem com que um bioma seja dotado de uma diversidade biológica singular, própria. No Brasil, os biomas existentes são: a Amazônia, o Cerrado, a Mata Atlântica, a Caatinga, o Pampa e o Pantanal. Sobre esse assunto, assinale a afirmativa correta.",
                ALTERNATIVES[9],
                Question.Alternative.C,
                600,
                "Dica 10"
        ),
        new Question(
                "O Cerrado é um dos biomas brasileiros mais ameaçados diante da sua biodiversidade e está presente também no estado de Goiás. A ameaça deste bioma se deve",
                ALTERNATIVES[10],
                Question.Alternative.D,
                200,
                "Dica 11"
        ),
        new Question(
                "Um problema que atinge o Bioma Cerrado é a caça e a pesca, aumentando o número de espécies ameaçadas de extinção. De acordo com a lista disponibilizada no ano de 2014 pelo ICMBio-MMA sobre espécies em ameaça de extinção nesse bioma, tem-se:",
                ALTERNATIVES[11],
                Question.Alternative.A,
                500,
                "Dica 12"
        ),
        new Question(
                "O bioma pode ser definido como um conjunto de tipos de vegetação característica que abrange grandes áreas contínuas, em escala regional, com flora e fauna similares, definida pelas condições físicas predominantes nas regiões. No Brasil, podemos definir seis amplos biomas (da maior extensão para a menor): a Amazônia, o Cerrado, a Mata Atlântica, a Caatinga, o Pampa e o Pantanal. Refletindo o fato de que os seres vivos de um bioma vivem de forma adaptada às condições da natureza (vegetação, chuva, umidade, calor, etc.) ali existentes, assinale a afirmação INCORRETA.",
                ALTERNATIVES[12],
                Question.Alternative.E,
                900,
                "Dica 13"
        ),
        new Question(
                "A Caatinga é um bioma que se concentra na região Nordeste do Brasil. Ocupando cerca de 10% do território nacional, ela cobre grandes faixas do Ceará, Piauí, Rio Grande do Norte, Paraíba, Pernambuco, Alagoas, Sergipe, Bahia e também um pedaço do Norte de Minas Gerais. Sobre o bioma Caatinga, marque a alternativa INCORRETA.",
                ALTERNATIVES[13],
                Question.Alternative.B,
                600,
                "Dica 14"
        ),
        new Question(
                "Importantes pesquisadores trabalham em conjunto desenvolvendo e propondo explicações teóricas para os processos evolutivos das espécies e sua distribuição no ambiente. Aziz Ab’Saber e Paulo Vanzolini foram exemplos deste trabalho em conjunto que contribui para a compreensão do bioma amazônico. O nome da teoria por eles pesquisada e o ramo científico a qual pertence são, respectivamente:",
                ALTERNATIVES[14],
                Question.Alternative.E,
                800,
                "Dica 15"
        ),
        new Question(
                "O bioma caracterizado pela presença marcante de árvores tortuosas de pequeno e médio porte, com cascas duras e grossas e folhas cobertas de pelos e por estações climáticas bem definidas, com uma época chuvosa e outra bastante seca, denomina-se",
                ALTERNATIVES[15],
                Question.Alternative.C,
                300,
                "Dica 16"
        ),
        new Question(
                "O único bioma exclusivamente brasileiro é",
                ALTERNATIVES[16],
                Question.Alternative.C,
                500,
                "Dica 17"
        ),
        new Question(
                "A floresta amazônica",
                ALTERNATIVES[17],
                Question.Alternative.B,
                700,
                "Dica 18"
        ),
        new Question(
                "O espaço físico, e seus fatores abióticos, onde se distribui determinada espécie é denominado",
                ALTERNATIVES[18],
                Question.Alternative.A,
                400,
                "Dica 19"
        ),
        new Question(
                "Os estudos sobre a ecologia do bioma Mata Atlântica, realizados pelos institutos de pesquisas, assim como as atitudes conservacionistas praticadas pelas diversas organizações não governamentais, no estado do Espírito Santo, apresentam particular importância, pois",
                ALTERNATIVES[19],
                Question.Alternative.C,
                600,
                "Dica 20"
        ),
        new Question(
                "Os estudos sobre a ecologia do bioma Mata Atlântica, realizados pelos institutos de pesquisas, assim como as atitudes conservacionistas praticadas pelas diversas organizações não governamentais, no estado do Espírito Santo, apresentam particular importância, pois",
                ALTERNATIVES[19],
                Question.Alternative.C,
                600,
                "Dica 20"
        ),
    };
}
