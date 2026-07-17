import { Menu } from "../components/elements/Menu";
import { getTarefas } from "../services/api"

export default async function PageTarefas(){

    const tarefas = await getTarefas();

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
                    {tarefas.length === 0 ? (
                        <p>Nenhuma tarefa cadastrada.</p>
                    ): (
                        tarefas.map((tarefa) => (
                            <article className="cardTarefa" key = {tarefa.id}>
                                <section className="tituloTarefa">
                                    <h2>{tarefa.titulo}</h2>
                                </section>
                                <p>{tarefa.descricao}</p>
                                <span>{tarefa.status}</span>
                                <span>{tarefa.prioridade}</span>
                            </article>
                        ))
                    )}
                </article>
            </article>
        </section>
    );
}