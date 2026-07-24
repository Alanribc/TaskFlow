import { Menu } from "@/app/components/elements/Menu";
import { getTarefaByID } from "@/app/services/api";

export default async function PageTarefaByID({ params }) {

    const { id } = await params;
    const tarefa = await getTarefaByID(id); 
    
    return (
            <section>
                <header>
                    <Menu></Menu>
                </header>
                <article>
                    <div>
                        <h1 className="minhasTarefas">Tarefa {tarefa.id}</h1>
                    </div>
                    <article className="repositorioTarefaUnica">
                        {!tarefa ? (
                            <p>Essa tarefa não foi cadastrada.</p>
                        ): (
                                <article className="cardTarefaUnica" key = {tarefa.id}>
                                    <section className="tituloTarefa">
                                        <h2>{tarefa.titulo}</h2>
                                    </section>
                                    <p>{tarefa.descricao}</p>
                                    <p>Data de conclusão: {tarefa.dataHora}</p>
                                    <p>Criado em: {tarefa.criadoEm}</p>
                                    <p>Última atualização: {tarefa.atualizadoEm}</p>
                                    
                                    <p></p>
                                    <span>{tarefa.status}</span>
                                    <br/>
                                    <span>{tarefa.prioridade}</span>
                                </article>
                            )
                        }
                    </article>
                </article>
            </section>
        );
}