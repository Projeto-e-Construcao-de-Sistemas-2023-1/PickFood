import Form from "@/components/Form";

export default function Login() {

    

    return (
        <>
            <Form>
                <Form.Field>
                    <Form.Label>Email</Form.Label>
                    <Form.Input/>
                </Form.Field>
                
                <Form.Field>
                    <Form.Label>Senha</Form.Label>
                    <Form.Input/>
                </Form.Field>

                
            </Form>
        </>
    )
}