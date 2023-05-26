'use client';

import Logo from "@/components/Logo";
import { logo, arrow } from "./styles.module.scss";
import Image from "next/image";
import Form from "@/components/Form";
import { useRouter } from "next/navigation";
import { useContext, useState } from "react";
import { AuthContext } from "@/app/layout";
import request from "@/services/axios";

export default function CadastroCliente() {

    const router = useRouter();

    const [nome, setNome] = useState("");
    const [email, setEmail] = useState("");
    const [senha, setSenha] = useState("");
    const [cpf, setCpf] = useState("");
    const [telefone, setTelefone] = useState("");

    const handleNome = (e) => {
        const valor = e.target.value;

        setNome(valor);
    }

    const handleEmail = (e) => {
        const valor = e.target.value;

        setEmail(valor);
    }

    const handleSenha = (e) => {
        const valor = e.target.value;

        setSenha(valor);
    }

    const handleCpf = (e) => {
        const valor = e.target.value;

        setCpf(valor);
    }

    const handleTelefone = (e) => {
        const valor = e.target.value;

        setTelefone(valor);
    }


    const { definirUsuario } = useContext(AuthContext);

    const cadastrar = () => {

        request.post("user", {
            nome,
            email,
            senha,
            cpf,
            telefone
        })
        .then((res) => {
            const dados = res.data;

            
        })

        definirUsuario(dados);


        router.push("/cliente/home")
    }

    return(
        <>
            <Image
                src="/icons/back.svg"
                width={ 21 }
                height={ 21 }
                className={ arrow }
                alt="Icone de seta apontando para trás."
            />
            <Logo className={ logo }/>
            <Form>
                <Form.Field>
                    <Form.Label>Nome e sobrenome</Form.Label>
                    <Form.Input value={ nome }/>
                </Form.Field>
                <Form.Field>
                    <Form.Label value={ email }>Email</Form.Label>
                    <Form.Input/>
                </Form.Field>
                <Form.Field>
                    <Form.Label>Senha</Form.Label>
                    <Form.Input value={ senha }/>
                </Form.Field>
                <Form.Field>
                    <Form.Label>CPF</Form.Label>
                    <Form.Input value={ cpf }/>
                </Form.Field>
                <Form.Field>
                    <Form.Label>Celular (DDD + número)</Form.Label>
                    <Form.Input value={ telefone }/>
                </Form.Field> 
                
                <Form.Button onClick={ cadastrar } >Cadastrar</Form.Button>
            </Form>
        </>
    )
}