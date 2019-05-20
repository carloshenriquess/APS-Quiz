package storage;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import model.Question;

public class Storage {
    public static final int PULOS = 50;
    public static final int ELIMINATIONS = 3;
    public static final int TIPS = 3;
    public static final int HELPS = 3;
    static final String[][] ALTERNATIVES = {
        {
            "conjunto de animais de uma área.",
            "onjunto de vertebrados de uma área.",
            "conjunto de plantas de uma área.",
            "conjunto de protozoários de uma área."
        },
        {
            "A flora é afetada por fatores como temperatura e regime de chuvas.",
            "Quando observamos a flora do Brasil, percebemos que as mesmas espécies ocorrem em todo o território nacional.",
            "A flora do Brasil apresenta uma grande quantidade de espécies endêmicas.",
            "Algumas espécies da flora brasileira não são encontradas em nenhum lugar do mundo."
        },
        {
            "ao conjunto de animais aquáticos de uma região.",
            "ao conjunto de obras que descrevem protozoários de uma região.",
            "ao conjunto de micro-organismos encontrados em nosso corpo.",
            "ao conjunto de espécies de animais endêmicas de uma área."
        },
        {
            "O termo “flora” é usado para nomear obras que descrevem plantas de uma área.",
            "O termo “flora” é utilizado para indicar a diversidade vegetal de uma área.",
            "O termo “flora” é usado para indicar o conjunto de micro-organismos em nosso corpo.",
            "O termo “flora” é usado para indicar a diversidade de animais de uma área."
        },
        {
            "Mata Atlântica.",
            "Pantanal.",
            "Amazônia.",
            "Pampas."
        },
        {
            "taxa reprodutiva líquida elevada e ausência de competidores fortes.",
            "crescimento populacional exponencial e capacidade de dispersão alta.",
            "natalidade elevada e alta resistência à invasão.",
            "capacidade de suporte elevada e área ampla."
        },
        {
            "Amazônia, Cerrado e Manguezal.",
            "Amazônia, Caatinga e Cerrado.",
            "Amazônia, Cerrado e Restinga.",
            "Caatinga, Cerrado e Manguezal."
        },
        {
            "A caatinga é constituída por árvores baixas, arbustos com poucas folhas, cactáceas e bromeliáceas.",
            "Os pampas, vegetação característica do estado do Paraná, são predominantemente formados por pinheiros do gênero Araucaria.",
            "A floresta amazônica é uma região cuja vegetação é característica de ambientes costeiros, com predominância de cactáceas.",
            "Formação arbórea aberta com vegetação herbácea abundante e presença de árvores geralmente pequenas com tronco retorcido e de casca grossa são características predominantes da caatinga."
        },
        {
            "A Mata Atlântica é caracterizada por formação vegetal de porte baixo e baixa diversidade de espécies, podendo apresentar diversos estágios sucessivos e vários estratos, com presença de serapilheira, cipós, epífitas e trepadeiras.",
            "O manguezal é uma faixa estreita paralela ao litoral, de vegetação exuberante e com grande diversidade de espécies arbóreas, como pau-brasil, guapuruvu e o cambuci.",
            "A caatinga apresenta uma grande riqueza de ambientes, vegetação do tipo savana estépica, e espécies que não são encontradas em nenhum outro bioma, denominadas espécies endêmicas.",
            "Na Bahia, as principais ameaças à biodiversidade do cerrado são os solos secos e de baixa fertilidade, com altos níveis de ferro e alumínio."
        },
        {
            "A Amazônia é o maior bioma do Brasil, em contrapartida apresenta uma diversidade biológica reduzida devido à crescente urbanização.",
            "O Pantanal é um bioma representado como uma planície inundável e no Brasil está presente nos estados de Mato Grosso e Goiás.",
            "O Pantanal é caracterizado por áreas inundáveis, sua vegetação é diversificada e pode variar nas áreas alagadas, as periodicamente alagadas e as que não são alagadas.",
            "O Cerrado apresenta espécies de plantas lenhosas que desenvolveram estruturas adaptativas para a sobrevivência nas suas condições ambientais, tais como casca fina sem sulcos, caules retilíneos e raízes aéreas"
        },
        {
            "à profundidade do solo e à pouca quantidade de nutrientes nele existente.",
            "às estações do ano bem definidas, sendo seca e chuvosa.",
            "à estrutura das árvores que possuem folhas rígidas e troncos retorcidos.",
            "às atividades humanas ligadas à agricultura e à pecuária."
        },
        {
            "a jaguatirica (Leopardus Pardalis).",
            "o jaú (Paulicea luetkeni).",
            "a seriema (Cariama cristata).",
            "o buriti (Mauritia flexuosa)."
        },
        {
            "O solo do Cerrado é normalmente mais pobre que o circundante, no caso da Mata Atlântica e da Amazônia, e sua vegetação é, em geral, de pequeno porte, com galhos retorcidos, casca e folhas grossas, capazes de melhor resistir a incêndios recorrentes.",
            "O Cerrado é constituído por várias características de vegetação, e pode ser classificado em subsistemas: de campo, de cerrado, de cerradão, de matas, de matas ciliares e de veredas em ambientes alagadiços.",
            "Como o solo é mais rico em nutrientes, a Caatinga apresenta uma grande riqueza de ambientes e espécies onde a seca, a luminosidade e o calor resultam numa vegetação xerófita espinhosa e decidual.",
            "A condição latifoliada da Amazônia se deve à grande facilidade de transpiração e captação de luz pelas folhas, além de solo mais rico em nutrientes do que os outros biomas brasileiros."
        },
        {
            "A vegetação é composta por plantas xerófitas que se adaptaram em um ambiente com poucas chuvas e baixa umidade. No bioma são comuns árvores baixas e arbustos, e a presença de espinhos em muitas espécies vegetais reduz a perda de água pela transpiração.",
            "A Caatinga está localizada em uma região com clima semiárido com árvores que, em geral, não perdem as folhas na estação das secas (espécies caducifólias).",
            "O bioma tem sido desmatado de forma acelerada, devido ao consumo de lenha nativa, explorada de forma ilegal e insustentável para fins domésticos e indústrias, ao sobrepastoreio e a conversão para pastagens e agricultura.",
            "Um estudo realizado pelo IBAMA determinou os três principais ecótonos no Brasil: o Cerrado-Amazônia, o Caatinga-Amazônia e o Cerrado-Caatinga."
        },
        {
            "teoria amazônica e ecologia de populações.",
            "teoria evolutiva e geografia de populações.",
            "teoria dispersiva e ocupação ambiental.",
            "teoria dos refúgios e biogeografia."
        },
        {
            "mata dos cocais.",
            "veredas.",
            "cerrado.",
            "mata atlântica."
        },
        {
            "o pampa.",
            "o pantanal.",
            "a caatinga.",
            "a floresta amazônica."
        },
        {
            "caracteriza-se, em termos de clima, por duas estações bem definidas, uma bastante seca e outra bastante chuvosa.",
            "é uma floresta tropical fechada, cujo solo não muito rico possui apenas uma fina camada de nutrientes.",
            "é também denominada de savana brasileira.",
            "caracteriza-se por períodos de seca, sendo composta por campos cobertos predominantemente por gramíneas."
        },
        {
            "hábitat.",
            "nicho ecológico.",
            "biocenose.",
            "ecossistema."
        },
        {
            "é o bioma que apresenta a maior preservação no estado, principalmente na região serrana.",
            "junto é o bioma que apresenta a maior preservação no estado, principalmente na região serrana.",
            "originalmente é o único bioma continental presente em toda a extensão territorial do estado.",
            "junto com os biomas restinga, manguezais e dunas compõe a fitofisionomia do estado."
        },
        {
            "Vários grupos de insetos estão representados por espécies capazes de viver no mangue. Muitos insetos como borboletas, besouros e moscas têm suas larvas fitófagas, alimentando-se da fauna de mangue.",
            "A maioria dos peixes de áreas costeiras, explorados comercialmente pela população humana, como sardinhas, tainhas, robalos e camarões, independem dos manguezais para sua sobrevivência, por serem marinhos.",
            "O manguezal é um ecossistema integrante do estuário marinho, habitado em toda a sua extensão por animais endógenos, que variam de formas microscópicas até grandes peixes, aves, répteis e mamíferos.",
            "Muitas espécies de aves se alimentam de peixes e crustáceos no mangue, e, em uma íntima relação com o ambiente, seus dejetos servem de adubo, o que torna esse ecossistema ainda mais rico e produtivo."
        },
        {
            "Muitos dos materiais tóxicos que os seres humanos acrescentam nos ecossistemas, como herbicidas e pesticidas, são derivados do benzeno, que apresenta potencial elevado de degradabilidade e que, por ser volátil, provoca problemas de toxicidade.",
            "O mundo anaeróbio representa o mundo primitivo — acreditase que as primeiras formas de vida eram eucariontes — uma vez que o mundo anaeróbio foi posteriormente substituído, expandindo a biodiversidade de organismos decompositores.",
            "Os compostos inorgânicos utilizados nos processos de decomposição microbiana servem de escoadouros da energia fixada posteriormente na fotossíntese, definindo o máximo de eficiência em processos de decomposição conjugada.",
            "Os produtos mais resistentes da decomposição acabam como substâncias húmicas — componente universal dos ecossistemas —, que são condensações de compostos aromáticos combinados com os produtos da decomposição de proteínas e polissacarídeos."
        },
        {
            "É o único bioma exclusivamente brasileiro. Seu nome é originário do tupi-guarani e sua flora se constitui de espécies xerófitas totalmente adaptadas ao clima seco, com predominâncias de cactáceas e bromeliáceas.",
            "Vegetação arbustivo-herbácea densa que domina a paisagem das regiões semiúmidas; encontra-se distribuído de forma bem heterogênea, compondo várias áreas de transição e sua maior concentração está na região centro-oeste do estado.",
            "Pode ser vista como um mosaico diversificado de ecossistemas; apresenta estruturas e composições florísticas diferenciadas em função de diferenças de solo, relevo e clima existentes na sua área de ocorrência; suas árvores abrigam uma grande diversidade de epífitas.",
            "É marcado por recifes calcários e arenitos, além de dunas que, quando perdem a cobertura vegetal que as fixa, movem-se com a ação do vento. Há ainda nessa área manguezais, restingas e matas. Se estende da foz do Rio Parnaíba até o Recôncavo."
        },
        {
            "I, II e III.",
            "I, II e IV.",
            "I, III e IV.",
            "II, III e IV."
        },
        {
            "equilibrar salários e preços, nos meios rural e urbano.",
            "ser ainda insuficientes para a mudança do quadro socioeconômico da sub-região.",
            "corrigir o desequilíbrio na criação de oportunidades de empregos urbanos e rurais.",
            "preparar a mão de obra necessária para atender as novas exigências do mercado de trabalho."
        },
        {
            "A Bahia, maior estado e o mais populoso da região Nordeste, é o que detém a maior parcela da população na zona urbana.",
            "Mesmo com as adversidades, quase metade da população do estado da Bahia ainda se encontra no semiárido.",
            "Depois da Bahia, os estados mais urbanizados da região Nordeste são Paraíba, Rio Grande do Norte e Ceará.",
            "O Brasil é um país essencialmente urbano, mas, na região Nordeste, alguns estados ainda concentram a maior parte da sua população no meio rural."
        },
        {
            "o Cerrado.",
            "a Caatinga.",
            "a Amazônia.",
            "o Pantanal."
        },
        {
            "Amazônia e Cerrado.",
            "Cerrado e Pantanal.",
            "Mata Atlântica e Amazônia.",
            "Cerrado e Mata Atlântica."
        },
        {
            "Mata Atlântica é o nome dado a floresta presente na região litorânea dos estados da região Sul e Sudeste e tem como símbolo principal o jacaré de papo amarelo.",
            "Na região litorânea do estado de São Paulo encontram-se fragmentos da Mata Atlântica original nos quais podemos encontrar grande diversidade de plantas e animais.",
            "A Floresta Amazônica é a maior floresta do mundo e está toda situada em território brasileiro; nela encontra-se o paubrasil, árvore que deu origem ao nome de nosso país.",
            "O Pantanal está localizado na Região Sudeste e apresenta como principal característica períodos de seca alternados com períodos de cheias."
        },
        {
            "É o ecossistema com a mais alta biodiversidade e o de maior extensão territorial.",
            "Pode ser considerado uma savana por apresentar vegetação xerófita.",
            "Apresenta período seco bem distinto e com alta biodiversidade.",
            "Tem solo fértil com chuvas bem distribuídas ao longo do ano."
        },
        {
            "diminuição de conflitos intra-específicos.",
            "um gradiente de pressões seletivas.",
            "um gradiente de taxas de mutação.",
            "aumento da riqueza de espécies."
        },
        {
            "são importantes para a proteção dos solos contra a erosão.",
            "são áreas insalubres e sem utilidade, a não ser para a cultura de arroz.",
            "a sua drenagem nunca foi permitida, o que gerou problemas ambientais.",
            "o excesso de vegetação e de algas causa o acúmulo de substâncias tóxicas na água."
        },
        {
            "Equatorial Continental (mEc ).",
            "Equatorial Atlântica (mEa).",
            "Tropical Continental (mTc).",
            "Tropical Atlântica (mTa)."
        },
        {
            "A jararaca, uma lepidóptera, é considerada um animal venenoso por produzir veneno e um aparato inoculador.",
            "O código internacional de classificação zoológica foi criado para mostrar o parentesco filogenético entre as diferentes espécies animais.",
            "A jararaca, assim como outras diversas serpentes, faz parte da lista de espécies da fauna ameaçadas de extinção em Goiás.",
            "A vegetação predominante no estado de Goiás é o Cerrado, mas há também pequenas faixas de Mata Atlântica."
        },
        {
            "O cerrado apresenta dois tipos principais de formação fitofisionômica: as savânicas e as campestres. A primeira inclui o cerradão e o cerrado em sentido restrito; e a segunda inclui o campo limpo, o campo sujo e as veredas.",
            "O pantanal é considerado uma fitofisionomia do tipo campo sujo úmido.",
            "O clima predominante do Cerrado é o tropical quente e seco, com uma estação seca e uma chuvosa, temperatura média anual entre 22° C e 27° C e precipitação inferior a 1000 mm anuais.",
            "A duração da estação seca pode chegar a 5 meses, no entanto a água não é fator limitante, devido à sua relativa abundância no solo."
        },
        {
            "vapor atmosférico - biomassa - rios - lagos - oceanos - gelo polar.",
            "biomassa - vapor atmosférico - rios - lagos - oceanos - gelo polar.",
            "gelo polar - oceanos - lagos - rios - vapor atmosférico - biomassa.",
            "biomassa - vapor atmosférico - lagos - rios - oceanos - gelo polar."
        },
        {
            "Pantanal e a Mata Atlântica.",
            "Cerrado e o Pampa.",
            "Cerrado e a Amazônia.",
            "Cerrado e a Mata Atlântica."
        },
        {
            "Mata ombrófila – é uma mata de inundação; no entanto, é relativamente mais baixa e de menores complexidade e biomassa em comparação com as outras matas.",
            "Mata de várzea – é uma mata de inundação onde há flutuação do nível de água de até 30 cm diários, devido ao fluxo das marés e à variação sazonal, ambos pouco conspícuos; cresce sobre solos de aluvião quaternários, ricos em nutrientes.",
            "Mata de igapó  ecossistema de maior extensão, perenifólia, com dossel de até 50 metros, densa vegetação arbustiva; cresce sobre latossolos amarelos de origem terciária com textura argiloarenosa, ácidos, profundos e oligotróficos.",
            "Capoeira ‒ apresenta características de cerrado, com estrato herbáceo contínuo, destacando-se as gramíneas, os arbustos e as árvores baixas de aspecto tortuoso e escleromórfico, crescendo sobre solos hidromórficos e argilosos de origem quaternária."
        },
        {
            "ecossistema.",
            "nicho.",
            "habitat.",
            "população."
        },
        {
            "Apenas os itens I e II estão certos.",
            "Apenas os itens I e III estão certos.",
            "Apenas os itens II e III estão certos.",
            "Todos os itens estão certos"
        },
        {
            "Floresta Ombrófila Aberta de Terras Baixas, sendo a fisionomia composta apenas por Aberta de Cipó.",
            "Floresta Ombrófila Aberta de Terras Baixas, sendo a fisionomia composta apenas por Aberta de Palmeira.",
            "Floresta Ombrófila Aberta de Terras Baixas, sendo a fisionomia com duas fisionomias: Aberta de Cipó e Aberta de Palmeira.",
            "Aluviais."
        },
        {
            "as embaúbas.",
            "as seringueiras.",
            "os castanheiros.",
            "as figueiras."
        },
        {
            "dos mamíferos.",
            "dos répteis.",
            "dos anfíbios.",
            "das aves."
        },
        {
            "Árvores de caules retilíneos, folhas perenes e raízes pouco profundas.",
            "Grandes arbustos, com folhas largas e poucos galhos.",
            "Espinhos e raízes aéreas para absorver a umidade do ar.",
            "Queda das folhas na estiagem, espinhos e raízes profundas."
        },
        {
            "A nas áreas das chamadas Unidades de Conservação, não é permitido nenhum tipo de exploração dos recursos naturais, apenas o turismo.",
            "O objetivo principal das Unidades de Conservação no país é a proteção da fauna e da flora; no entanto, ao impedir a destruição desses elementos, também protege a geologia e o relevo de ações de degradação do ambiente.",
            "Há exemplos de comunidades ribeirinhas na Amazônia que sobrevivem dentro de uma Unidade de Conservação utilizando de forma equilibrada os recursos naturais e ainda recebendo visitantes para práticas de ecoturismo.",
            "Como em outros países, o Brasil conta com uma bem estruturada rede de proteção à fauna e à flora, com infraestrutura organizada para educação ambiental e ecoturismo, na qual todas as Unidades de Conservação federais – que são espaços fundamentais para a observação da natureza – estão incluídas."
        },
        {
            "Mundial, porque as espécies levaram milhões de anos para se desenvolverem e muitas delas podem desaparecer do mundo em poucas décadas, se a poluição e o desmatamento indiscriminado tiverem continuidade.",
            "Regional, porque o desaparecimento de espécies de animais pode ser responsável por problemas alimentares e pelo aumento de pragas, pela ruptura da cadeia alimentar, em algumas regiões do mundo.",
            "Apenas para os Estados Unidos e países da Europa que já destruíram quase totalmente suas florestas, por terem desenvolvido seu setor industrial há muito tempo.",
            "Apenas para países e regiões que se organizaram politicamente em espaços áridos ou semiáridos, como a Namíbia e o Nordeste do Brasil, que dependem do pouco que resta de seus ecossistemas."
        },
        {
            "Praticar abuso ou crueldade, golpear, ferir, mutilar, envenenar, causar estresse e angústia, realizar experiência dolorosa ou cruel em espécime vivo.",
            "Vender, expor à venda, adquirir, guardar, transportar, e exportar espécimes vivos ou abatidos, ovos, filhotes, larvas, produtos e objetos oriundos da fauna silvestre brasileira sem permissão da autoridade competente.",
            "Manter em lugares anti-higiênicos, sem ventilação, luz e proporções necessárias ao tamanho e número de indivíduos, privar de satisfação das necessidades básicas e obrigar a trabalhos excessivos ou superiores às suas forças.",
            "Abandonar ou deixar de ministrar assistência, inclusive veterinária, utilizar em serviço animal cego ou debilitado, realizar ou promover lutas (rinhas), entre outros."
        },
        {
            "Tropófila e clima tropical.",
            "Xerófila e clima semiárido.",
            "Hidrófila e clima equatorial.",
            "Aciculifoliada e clima subtropical."
        },
        {
            "Floresta tropical.",
            "Caatinga.",
            "Formação do Pantanal.",
            "Cerrado."
        },
        {
            "Se localizam nas mais altas latitudes do planeta.",
            "São constituídas de baixa a média biodiversidade.",
            "São os ecossistemas mais bem preservados da Terra.",
            "Têm uma composição de flora dominantemente latifoliada."
        }
    };
    public static List<Question> getQuestions() {
        List<Question> questions = new ArrayList<>();
        questions.add(
            new Question(
                "Quando falamos da flora de uma região, estamos referindo-nos ao",
                ALTERNATIVES[0],
                Question.Alternative.C,
                5,
                "Flora é o conjunto de plantas de uma região."
            )
        );
        questions.add(new Question(
                "O termo “flora” é bastante conhecido de todos e refere-se à diversidade vegetal. Sobre o tema, marque a alternativa incorreta.",
                ALTERNATIVES[1],
                Question.Alternative.B,
                10,
                "Flora é o conjunto de plantas de uma região."
        ));
        questions.add(new Question(
                "Quando falamos em flora, normalmente, estamos referindo-nos à diversidade de plantas de uma área. Entretanto, o termo “flora” pode ser usado em outros casos, como para se referir:",
                ALTERNATIVES[2],
                Question.Alternative.C,
                15,
                "O termo “flora” é usado também para indicar o conjunto de micro-organismos presente em nosso corpo. Um exemplo desse uso é “flora intestinal”."
        ));
        questions.add(new Question(
                "O termo “flora” pode ser utilizado em diferentes casos. Analise as afirmações abaixo e marque aquela que não indica um uso correto para esse termo.",
                ALTERNATIVES[3],
                Question.Alternative.D,
                10,
                "O termo adequado para indicar a diversidade animal é “fauna”."
        ));
        questions.add(new Question(
                "Segundo o IBGE, o Brasil possui seis grandes biomas, que abrigam uma das maiores biodiversidades do planeta. Entre esses biomas, inclui-se o bioma influenciado pelo clima subtropical e pela formação do relevo, de clima frio e seco, cuja vegetação é constituída principalmente por gramíneas. Tal bioma denomina-se",
                ALTERNATIVES[4],
                Question.Alternative.D,
                5,
                "Em sua maior parte, destaca-se o relevo de planícies, constituído de grandes áreas de pastagens que se desenvolvem grandes rebanhos."
        ));
        questions.add(new Question(
                "Em uma comunidade biótica, a dominância de uma espécie exótica invasora resulta tanto de atributos de sua população como do ambiente, exemplificados, respectivamente, por",
                ALTERNATIVES[5],
                Question.Alternative.A,
                15,
                "Conjunto de todos os seres vivos de diferentes espécies que habitam numa mesma área e que podem estabelecer interacções entre si."
        ));
        questions.add(new Question(
                "Os três biomas que ocorrem no Estado do Maranhão, e que estão representados no Parque Nacional dos Lençóis Maranhenses, são:",
                ALTERNATIVES[6],
                Question.Alternative.B,
                15,
                "Caracterizado por uma vegetação baixa, arbustos espaçados e gramíneas. É considerado o bioma mais preservado. É considerado o bioma mais preservado"
        ));
        questions.add(new Question(
                "Assinale a alternativa correta",
                ALTERNATIVES[7],
                Question.Alternative.A,
                15,
                "Semiárido, vegetação com poucas folhas e adaptadas para os períodos de secas, além de grande biodiversidade."
        ));
        questions.add(new Question(
                "Assinale a alternativa correta",
                ALTERNATIVES[8],
                Question.Alternative.C,
                15,
                "Semiárido, vegetação com poucas folhas e adaptadas para os períodos de secas, além de grande biodiversidade."
        ));
        questions.add(new Question(
                "Um bioma é um conjunto de tipos de vegetação que abrange grandes áreas contínuas, em escala regional, com flora e fauna similares, definidas pelas condições físicas predominantes nas regiões. Esses aspectos climáticos, geográficos e litológicos, por exemplo, fazem com que um bioma seja dotado de uma diversidade biológica singular, própria. No Brasil, os biomas existentes são: a Amazônia, o Cerrado, a Mata Atlântica, a Caatinga, o Pampa e o Pantanal. Sobre esse assunto, assinale a afirmativa correta.",
                ALTERNATIVES[9],
                Question.Alternative.C,
                10,
                "É um bioma constituído principalmente por uma savana estépica, alagada em sua maior parte, com 250 mil quilômetros quadrados de extensão, altitude média de 100 metros."
        ));
        questions.add(new Question(
                "O Cerrado é um dos biomas brasileiros mais ameaçados diante da sua biodiversidade e está presente também no estado de Goiás. A ameaça deste bioma se deve",
                ALTERNATIVES[10],
                Question.Alternative.D,
                5,
                "Caracteriza-se por ser uma região de savana, estendendo-se por cerca de 200 milhões de quilômetros quadrados. Possui uma formação vegetal de grande biodiversidade e grande potencial aquífero, no entanto, é considerado atualmente o segundo bioma do Brasil mais ameaçado."
        ));
        questions.add(new Question(
                "Um problema que atinge o Bioma Cerrado é a caça e a pesca, aumentando o número de espécies ameaçadas de extinção. De acordo com a lista disponibilizada no ano de 2014 pelo ICMBio-MMA sobre espécies em ameaça de extinção nesse bioma, tem-se:",
                ALTERNATIVES[11],
                Question.Alternative.A,
                10,
                "(Leopardus Pardalis)."
        ));
        questions.add(new Question(
                "O bioma pode ser definido como um conjunto de tipos de vegetação característica que abrange grandes áreas contínuas, em escala regional, com flora e fauna similares, definida pelas condições físicas predominantes nas regiões. No Brasil, podemos definir seis amplos biomas (da maior extensão para a menor): a Amazônia, o Cerrado, a Mata Atlântica, a Caatinga, o Pampa e o Pantanal. Refletindo o fato de que os seres vivos de um bioma vivem de forma adaptada às condições da natureza (vegetação, chuva, umidade, calor, etc.) ali existentes, assinale a afirmação INCORRETA.",
                ALTERNATIVES[12],
                Question.Alternative.D,
                10,
                "Latifoliada é um tipo de vegetação que apresenta folhas largas e grandes, geralmente presente em regiões quentes para permitir a intensa transpiração."
        ));
        questions.add(new Question(
                "A Caatinga é um bioma que se concentra na região Nordeste do Brasil. Ocupando cerca de 10% do território nacional, ela cobre grandes faixas do Ceará, Piauí, Rio Grande do Norte, Paraíba, Pernambuco, Alagoas, Sergipe, Bahia e também um pedaço do Norte de Minas Gerais. Sobre o bioma Caatinga, marque a alternativa INCORRETA.",
                ALTERNATIVES[13],
                Question.Alternative.B,
                10,
                "É um bioma brasileiro que apresenta clima semiárido, vegetação com poucas folhas e adaptadas para os períodos de secas, além de grande biodiversidade."
        ));
        questions.add(new Question(
                "Importantes pesquisadores trabalham em conjunto desenvolvendo e propondo explicações teóricas para os processos evolutivos das espécies e sua distribuição no ambiente. Aziz Ab’Saber e Paulo Vanzolini foram exemplos deste trabalho em conjunto que contribui para a compreensão do bioma amazônico. O nome da teoria por eles pesquisada e o ramo científico a qual pertence são, respectivamente:",
                ALTERNATIVES[14],
                Question.Alternative.D,
                10,
                "Haffer mostra que dados geomorfológicos da região norte da América do Sul, indicam que durante o período Quaternário, condições climáticas secas prevaleceram repetidas vezes na Amazônia."
        ));
        questions.add(new Question(
                "O bioma caracterizado pela presença marcante de árvores tortuosas de pequeno e médio porte, com cascas duras e grossas e folhas cobertas de pelos e por estações climáticas bem definidas, com uma época chuvosa e outra bastante seca, denomina-se",
                ALTERNATIVES[15],
                Question.Alternative.C,
                5,
                "É uma área fito e biogeográfica (ou bioma, na acepção do IBGE) do Brasil, caracterizada especialmente pelo bioma savana, mas também por floresta estacional e campo"
        ));
        questions.add(new Question(
                "O único bioma exclusivamente brasileiro é",
                ALTERNATIVES[16],
                Question.Alternative.C,
                10,
                "O nome _____________ possui origem tupi-guarani e significa “floresta branca”. Essa denominação representa as características da vegetação desse ecossistema, cujas folhas caem no período da seca."
        ));
        questions.add(new Question(
                "A floresta amazônica",
                ALTERNATIVES[17],
                Question.Alternative.B,
                15,
                "Esta bacia abrange 7 milhões de quilômetros quadrados, dos quais 5 milhões e meio de quilômetros quadrados são cobertos pela floresta tropical."
        ));
        questions.add(new Question(
                "O espaço físico, e seus fatores abióticos, onde se distribui determinada espécie é denominado",
                ALTERNATIVES[18],
                Question.Alternative.A,
                5,
                "É uma área ecológica ou ambiental que é habitada por uma determinada espécie de animal, planta ou outro organismo."
        ));
        questions.add(new Question(
                "Os estudos sobre a ecologia do bioma Mata Atlântica, realizados pelos institutos de pesquisas, assim como as atitudes conservacionistas praticadas pelas diversas organizações não governamentais, no estado do Espírito Santo, apresentam particular importância, pois",
                ALTERNATIVES[19],
                Question.Alternative.C,
                15,
                "Originalmente, essa formação vegetal ocupava uma área de 1.300.000 km², em áreas de 17 estados, ocorrendo de forma contínua entre RN e RS."
        ));
        questions.add(new Question(
                "O estuário na região litorânea do Brasil é um sistema costeiro caracterizado pela mistura de água salina e água doce dos rios que desembocam no mar. O manguezal se destaca como um hábitat favorável ao desenvolvimento e à reprodução de certos organismos. Acerca desse assunto, assinale a opção correta.",
                ALTERNATIVES[20],
                Question.Alternative.D,
                15,
                "Um estuário é um ambiente aquático de transição entre um rio e o mar."
        ));
        questions.add(new Question(
                "Os processos de decomposição na estrutura trófica de ambientes naturais resultam em processos tanto bióticos quanto abióticos. A decomposição, portanto, ocorre através de transformações de energia dentro dos organismos, sendo uma função absolutamente vital dos ecossistemas. De acordo com o texto, assinale a opção correta.",
                ALTERNATIVES[21],
                Question.Alternative.D,
                15,
                "A estrutura trófica, baseia-se nas relações alimentares entre as várias espécies constituintes da comunidade."
        ));
        questions.add(new Question(
                "Assinale a opção correspondente a característica do mais abrangente bioma da Bahia.",
                ALTERNATIVES[22],
                Question.Alternative.A,
                15,
                "Vegetação com poucas folhas e adaptadas para os períodos de secas, além de grande biodiversidade."
        ));
        
        questions.add(new Question(
                "O Projeto do IBAMA, de conservação e manejo do bioma caatinga, visa conservar, ordenar o uso sustentável dos recursos naturais e contribuir para a divisão equitativa da riqueza. O referido projeto contempla a ação de: I identificar áreas para a criação de novas unidades de conservação. II introduzir atividades totalmente adversas de sua estrutura original. III definir e estabelecer corredores ecológicos. IV realizar estudos de valoração econômica da biodiversidade. Estão certos apenas os itens",
                ALTERNATIVES[23],
                Question.Alternative.C,
                10,
                "O objetivo de promover a conservação, a recuperação e o manejo sustentável de ecossistemas naturais, bem como a valorização e o reconhecimento de suas populações locais, buscando condições para reverter os impactos sócio-ambientais negativos no bioma Cerrado"
        ));
        questions.add(new Question(
                "As políticas públicas que vêm sendo implementadas no semiárido nordestino se caracterizam por",
                ALTERNATIVES[24],
                Question.Alternative.B,
                10,
                "As medidas que envolvem a politica não resolveram os principais problemas da região."
        ));
        questions.add(new Question(
                "A ocorrência de mais uma seca no Nordeste brasileiro traz de volta, aos meios de comunicação, imagens bastante conhecidas, que dão testemunho da vulnerabilidade que ainda cerca as atividades econômicas do semiárido e de sua população, levando à migração, que sempre foi uma característica marcante na região Nordeste. Acerca desse tema, assinale a opção correta.",
                ALTERNATIVES[25],
                Question.Alternative.B,
                10,
                "Dentre os muitos aspectos apresentados pela Região Nordeste o que mais se destaca é a seca, causada pela escassez de chuvas, proporcionando pobreza e fome."
        ));
        questions.add(new Question(
                "O bioma, exclusivamente brasileiro, conhecido como mata branca é:",
                ALTERNATIVES[26],
                Question.Alternative.B,
                5,
                "Vegetação com poucas folhas e adaptadas para os períodos de secas, além de grande biodiversidade."
        ));
        questions.add(new Question(
                "Dentre os hotspots de biodiversidade no mundo, definidos pela Conservation International, dois ocorrem no Brasil. São eles:",
                ALTERNATIVES[27],
                Question.Alternative.A,
                5,
                "O termo hotspots é utilizado para designar lugares que apresentam uma grande riqueza natural e uma elevada biodiversidade."
        ));
        questions.add(new Question(
                "O Brasil é considerado o país com maior diversidade biológica do planeta, já que aproximadamente 13% das espécies conhecidas estão no seu território. Esse grande número de espécies vive em ambientes muito diferentes, como é o caso da Mata Atlântica, do Cerrado, do Pantanal e da Floresta Amazônica. Sobre esses ambientes é correto afirmar:",
                ALTERNATIVES[28],
                Question.Alternative.B,
                10,
                "Litoral Norte: Vale do Paraíba. Litoral Sul: Vale do Ribeira. Litoral Central: Baixada Santista"
        ));
        questions.add(new Question(
                "A região Norte Mineira é caracterizada por um bioma brasileiro que apresenta arbustos e árvores com troncos retorcidos, campos com grande presença de gramíneas e onde as atividades agropecuárias são importantes. Assinale a alternativa CORRETA que completa as características desse bioma.",
                ALTERNATIVES[29],
                Question.Alternative.C,
                5,
                "Caatinga"
        ));
        questions.add(new Question(
                "O território brasileiro apresenta zonas de transição entre os seus biomas. Alguns ambientalistas preocupam-se com a manutenção destas zonas de transição, por serem consideradas evolutivamente muito dinâmicas. Considera-se que ao longo de uma zona de transição ocorre",
                ALTERNATIVES[30],
                Question.Alternative.B,
                10,
                "Algumas zonas com características específicas, existentes entre os principais biomas brasileiros, foram identificadas e separadas para facilitar as tarefas e esforços de conservação. Uma delas é a transição entre o Cerrado e a Amazônia, com área de 414.007 km², envolvendo as florestas secas de Mato Grosso"
        ));
        questions.add(new Question(
                "Sobre os banhados, um ecossistema comum no Rio Grande do Sul, é correto afirmar que",
                ALTERNATIVES[31],
                Question.Alternative.A,
                5,
                "São áreas alagadas permanente ou temporariamente. Podem ser alimentados por água das chuvas, pelo escoamento de águas superficiais ou subterrâneas ou por rios e arroios que trasbordam quando chove muito."
        ));
        questions.add(new Question(
                "A massa de ar com característica quente e úmida originada na Amazônia ocidental, que exerce influência em quase todo o país durante o verão do hemisfério sul, sendo responsável pelas altas temperaturas e altos índices pluviométricos da região amazônica é denominada Massa",
                ALTERNATIVES[32],
                Question.Alternative.A,
                5,
                "É uma massa de ar de aspecto quente e úmido que é originada na região central do estado brasileiro do Amazonas."
        ));
        questions.add(new Question(
                "Com base em ecologia, zoologia e botânica, assinale a alternativa correta.",
                ALTERNATIVES[33],
                Question.Alternative.D,
                10,
                "É dominada pelo Cerrado em seu território, com árvores e arbustos de galhos tortuosos, cascas grossas, folhas cobertas por pelos e raízes muito profundas."
        ));
        questions.add(new Question(
                "O Cerrado é o segundo maior bioma da América do Sul e cobre 22% do território brasileiro. No entanto, devido à sua grande diversidade paisagística e fitofisionômica, ainda é mal compreendido. Com fundamento nesse bioma, assinale a alternativa correta.",
                ALTERNATIVES[34],
                Question.Alternative.D,
                5,
                "Cerrado é uma área fito- e biogeográfica do Brasil, caracterizada especialmente pelo bioma savana, mas também por floresta estacional e campo."
        ));
        questions.add(new Question(
                "A água na biosfera faz parte de um ciclo denominado ciclo hidrológico que consiste, basicamente, em um processo contínuo de transporte de massas d'água entre diferentes compartimentos. O tempo de residência de uma molécula de água nos diferentes compartimentos é variável. A ordem crescente para o tempo de residência de uma molécula de água entre os diferentes compartimentos é:",
                ALTERNATIVES[35],
                Question.Alternative.B,
                10,
                "Refere-se à troca contínua de água na hidrosfera, entre a atmosfera, a água do solo, águas superficiais, subterrâneas e das plantas."
        ));
        questions.add(new Question(
                "Os dois biomas brasileiros que são considerados hotspot de biodiversidade pela Conservation Internacional são o",
                ALTERNATIVES[36],
                Question.Alternative.D,
                5,
                "O Brasil é campeão de megadiversidade, tendo maior número de espécies do que qualquer outra nação. Possui também o maior bloco de área verde do planeta – floresta amazônica."
        ));
        questions.add(new Question(
                "Assinale a alternativa que apresenta ecossistema encontrado na Amazônia corretamente definido.",
                ALTERNATIVES[37],
                Question.Alternative.B,
                5,
                "É um tipo de floresta de planícies inundáveis invadidas por enchentes sazonais na bacia Amazônica, ao longo de rios de 'águas brancas'."
        ));
        questions.add(new Question(
                "Considere-se que coletas de briófitas tenham sido realizadas nos substratos: folha (folhas velhas e(ou) com maior diversidade de briófitas, de arbustos e árvores jovens de até 2 metros de altura)); tronco vivo (até a altura de 2 metros));, base ao nível do solo ou raiz de tronco vivo; tronco morto; solo; cupinzeiro e concreto. Nesse contexto, cada substrato estudado corresponde a",
                ALTERNATIVES[38],
                Question.Alternative.C,
                5,
                "Uma área ecológica ou ambiental que é habitada por uma determinada espécie de animal, planta ou outro organismo. O termo refere-se tipicamente à zona em que o organismo vive e onde pode encontrar alimento, abrigo, proteção e companheiros para reprodução."
        ));
        
        questions.add(new Question(
                "A queda das folhas na estação seca e a presença de raízes bem desenvolvidas são duas adaptações importantes à vida das plantas na caatinga. A respeito das características das plantas da caatinga, julgue os itens a seguir: I A perda das folhas na estação seca é uma adaptação das plantas que reduz a perda de água por transpiração. II As plantas da caatinga são de grande porte. III Raízes bem desenvolvidas aumentam a capacidade das plantas da caatinga de obter água do solo. Assinale a opção correta.",
                ALTERNATIVES[39],
                Question.Alternative.B,
                5,
                "A vegetação da Caatinga é considerada por muitos como semelhante a de um deserto, pois o clima seco e a vegetação rasteira impossibilita a plantação de diversas espécies vegetais."
        ));
        questions.add(new Question(
                "O Parque Nacional da Serra do Divisor no Acre, apresenta a maior parte da área coberta por:",
                ALTERNATIVES[40],
                Question.Alternative.C,
                5,
                "Tem como característica ambientes com climas mais secos, que chegam de 2 a 4 meses por ano, com temperaturas de 24 à 25°C. É encontrada também em algumas áreas da Bahia, Espírito Santo, Alagoas, Pernambuco e Paraíba."
        ));
        questions.add(new Question(
                "A Estação Ecológica Rio Acre foi criada em 2 de junho de 1981. A vegetação é caracterizada como Floresta Ombrófila Aberta de Terras Baixas, existindo na área florestas abertas de palmeiras e bambus. Nas proximidades das margens do Rio Acre são encontradas plantas consideradas pioneiras e que se desenvolvem quase como uma floresta homogênea, dominando a paisagem em vários trechos. Essas plantas são:",
                ALTERNATIVES[41],
                Question.Alternative.A,
                5,
                "Encontradas na Mata Atlântica e em outros locais no país, as _________ são árvores de porte médio, com caule reto e ramificação apenas na porção superior."
        ));
        questions.add(new Question(
                "O uacari-vermelho (Cacajao calvus) é uma das espécies de destaque do Parque Nacional da Serra do Divisor. Esta espécie pertence ao grupo",
                ALTERNATIVES[42],
                Question.Alternative.A,
                5,
                "Constituem uma classe de animais vertebrados do domínio Eukaryota, do Reino Animalia e Filo Chordata, subdivididos em dois grupos: aquáticos e terrestres, que se caracterizam pela presença de glândulas mamárias."
        ));
        questions.add(new Question(
                "“Chegariam a uma terra desconhecida e civilizada, ficariam presos nela. E o sertão continuaria a mandar gente para lá. O sertão mandaria para cidade homens fortes, brutos, como Fabiano, Sinhá Vitória e os dois meninos”. G. Ramos Vidas Secas. A caatinga, adaptada às condições naturais sertanejas, é uma vegetação que apresenta:",
                ALTERNATIVES[43],
                Question.Alternative.D,
                5,
                "Apresenta clima semiárido, vegetação com poucas folhas e adaptadas para os períodos de secas, além de grande biodiversidade."
        ));
        
        questions.add(new Question(
                "As chamadas Unidades de Conservação são fundamentais para a proteção da fauna e da flora no Brasil e para o desenvolvimento sustentável do país. Unidade de Conservação: espaço territorial e seus recursos ambientais, incluindo as águas jurisdicionais, com características naturais relevantes, legalmente instituído pelo Poder Público, com objetivos de conservação e limites definidos, sob regime especial de administração, ao qual se aplicam garantias adequadas de proteção. (Lei Federal n. 9.985, de 18 de julho de 2000). Sobre a afirmação e a definição legal, é INCORRETO afirmar que:",
                ALTERNATIVES[44],
                Question.Alternative.D,
                5,
                "É usado para designar um grupo de organismos que viveu em uma determinada época geológica."
        ));
        questions.add(new Question(
                "Preservar a biodiversidade constitui uma das condições básicas para manter os ambientes sadios no nosso planeta. Essa afirmação refere-se a uma preocupação:",
                ALTERNATIVES[45],
                Question.Alternative.A,
                5,
                "Ações humanas e suas consequências diretas podem causar uma notória falta de preservação da biodiversidade mundial."
        ));
        questions.add(new Question(
                "A biopirataria não é apenas o contrabando de diversas formas de vida da flora e fauna, mas principalmente, a apropriação e monopolização dos conhecimentos das populações tradicionais no que se refere ao uso dos recursos naturais. Esta prática envolve diversos tipos de crime, incluindo contra a fauna. Assinale o item abaixo que descreve o comércio ilegal de fauna.",
                ALTERNATIVES[46],
                Question.Alternative.B,
                5,
                "É uma das atividades ilícitas mais lucrativas do planeta perdendo apenas para o tráfico de drogas e de armas, movimentando mais de US$10 bilhões por ano, sendo somente no Brasil, cerca de US$1 a 1,5 bilhões por ano."
        ));
        questions.add(new Question(
                "Ao destruir uma paisagem de árvores de troncos retorcidos, folhas e arbustos ásperos sobre os solos ácidos, não raro laterizados ou tomados pelas formas bizarras dos cupinzeiros, essa modernização lineariza e aparentemente não permite que se questione a pretensão modernista de que a forma deve seguir a função. O processo descrito ocorre em uma área biogeográfica com predomínio de vegetação:",
                ALTERNATIVES[47],
                Question.Alternative.A,
                5,
                "É uma vegetação adaptada à variações de umidade, segundo a estação, seca ou chuvosa. As plantas são de características caducifólias (plantas que perdem as folhas em estações umidas ou quentes)."
        ));
        questions.add(new Question(
                "“De origem bastante discutida, essa formação é característica das áreas onde o clima apresenta duas estações bem marcadas: uma seca e outra chuvosa, como no Planalto Central. Ela apresenta 2 estratos nítidos: uma arbóreo-arbustivo, onde as espécies tortuosas têm os caules geralmente revestidos de casca espessa, e outro herbáceo, geralmente dispostos em tufos”. O texto refere-se à qual formação vegetal?",
                ALTERNATIVES[48],
                Question.Alternative.D,
                5,
                "É uma área fito e biogeográfica (ou bioma, na acepção do IBGE) do Brasil, caracterizada especialmente pelo bioma savana, mas também por floresta estacional e campo"
        ));
        questions.add(new Question(
                "Em relação às florestas tropicais úmidas, é correto afirmar que:",
                ALTERNATIVES[49],
                Question.Alternative.D,
                5,
                "Perda de água de uma comunidade ou ecossistema para a atmosfera, causada pela evaporação a partir do solo e pela transpiração das plantas."
        ));
        Collections.shuffle(questions);
        return questions;
    }
}
