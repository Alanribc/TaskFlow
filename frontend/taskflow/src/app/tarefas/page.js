import Link from "next/link";
import { Menu } from "../components/elements/Menu";
import { getTarefas } from "../services/api"
import Image from "next/image";

export default async function PageTarefas(){

    const tarefas = await getTarefas();

    return (
        <section>
            <header>
                <Menu></Menu>
            </header>
            <article>
                <div className="minhasTarefas">
                    <h1>Minhas tarefas</h1>
                    <section className="sectionAdicionar">
                        <Image
                            src = "/mais-pequeno.png"
                            width = {100}
                            height = {100}
                            alt = "sinal de mais"
                            className="sinaldeMais"
                        ></Image>
                        <h2>Adicionar Tarefa</h2>
                    </section>
                </div>
                <article className="repositorioTarefas">
                    {tarefas.length === 0 ? (
                        <p>Nenhuma tarefa cadastrada.</p>
                    ): (
                        tarefas.map((tarefa) => (
                            <Link className="cardTarefa" href={`/tarefas/${tarefa.id}`} key={tarefa.id}>
                                <article key = {tarefa.id}>
                                    <section className="tituloTarefa">
                                        <h2>{tarefa.titulo}</h2>
                                    </section>
                                    <p>{tarefa.descricao}</p>
                                    <span>{tarefa.status}</span>
                                    <span>{tarefa.prioridade}</span>
                                </article>
                            </Link>
                        ))
                    )}
                </article>
            </article>
        </section>
    );
}