import { Geist, Geist_Mono } from "next/font/google";
import "./globals.css";
import { Menu } from "./components/elements/Menu";

const geistSans = Geist({
  variable: "--font-geist-sans",
  subsets: ["latin"],
});

const geistMono = Geist_Mono({
  variable: "--font-geist-mono",
  subsets: ["latin"],
});

export const metadata = {
  title: "Taskflow",
  description: "Aplicativo de organização de tarefas",
};

export default function RootLayout({ children }) {
  return (
    <html lang="pt-br" className={`${geistSans.variable} ${geistMono.variable}`}>
  
      <body>
        <Menu></Menu>
        {children}
      </body>
    </html>
  );
}
