import { getTarefas } from "../services/api"

export default async function PageTarefas(){

    const tarefas = await getTarefas();

    return (
        <section>
            <article>
                <h1 className="minhasTarefas">Minhas tarefas</h1>

                {tarefas.length === 0 ? (
                    <p>Nenhuma tarefa cadastrada.</p>
                ): (
                    tarefas.map((tarefa) => (
                        <article className="cardTarefa" key = {tarefa.id}>
                            <h2>{tarefa.titulo}</h2>
                            <p>{tarefa.descricao}</p>
                            <span>{tarefa.status}</span>
                            <span>{tarefa.prioridade}</span>
                        </article>
                    ))
                )}

            </article>
        </section>
    );
}