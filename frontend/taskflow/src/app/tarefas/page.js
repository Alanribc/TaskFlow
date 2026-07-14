import { getTarefas } from "../services/api"

export default async function PageTarefas(){

    const tarefas = await getTarefas();

    return (
        <section>
            <article>
                <h1>Minhas tarefas</h1>
                {tarefas.map((tarefa) => (
                    <div key = {tarefa.id}>
                        <h2>{tarefa.titulo}</h2>
                        <p>{tarefa.dataHora}</p>
                    </div>
                ))}
            </article>
        </section>
    )
}