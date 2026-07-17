import { Menu } from "./components/elements/Menu";

export default function Home() {
  return (
    <div>
      <main>
        <header>
          <Menu></Menu>
        </header>
        <aside></aside>
        <section>
          <article className="articleInicial">
            <h1>Bem-vindo ao Taskflow!</h1>
            <p>Nesse aplicativo, você poderá organizar suas tarefas e rotina de forma simples e fácil.</p>
          </article>
        </section>
      </main>
    </div>
  );
}
