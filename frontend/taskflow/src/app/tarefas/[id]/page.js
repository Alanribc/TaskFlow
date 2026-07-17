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
                        <h1 className="minhasTarefas">Minhas tarefas</h1>
                    </div>
                    <article className="repositorioTarefas">
                        {!tarefa ? (
                            <p>Essa tarefa não foi cadastrada.</p>
                        ): (
                                <article className="cardTarefa" key = {tarefa.id}>
                                    <section className="tituloTarefa">
                                        <h2>{tarefa.titulo}</h2>
                                    </section>
                                    <p>{tarefa.descricao}</p>
                                    <span>{tarefa.status}</span>
                                    <span>{tarefa.prioridade}</span>
                                </article>
                            )
                        }
                    </article>
                </article>
            </section>
        );
}