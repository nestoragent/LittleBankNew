const React = require('react');
const ReactDOM = require('react-dom');
const client = require('./client');


class App extends React.Component {

    constructor(props) {
        super(props);
        this.state = {bankAccounts: []};
    }

    componentDidMount() {
        client({method: 'GET', path: '/api/bankAccounts'}).done(response => {
            this.setState({bankAccounts: response.entity._embedded.bankAccounts});
        });
    }

    render() {
        return (
            <BankAccountList bankAccounts={this.state.bankAccounts}/>
        )
    }
}

class BankAccountList extends React.Component{
    render() {
        const bankAccounts = this.props.bankAccounts.map(bankAccount =>
            <BankAccount key={bankAccount._links.self.href} bankAccount={bankAccount}/>
        );
        return (
            <table>
                <tbody>
                <tr>
                    <th>Account Number</th>
                    <th>IBAN</th>
                    <th>Bank Name</th>
                    <th>bic</th>
                </tr>
                {bankAccounts}
                </tbody>
            </table>
        )
    }
}

class BankAccount extends React.Component{
    render() {
        return (
            <tr>
                <td>{this.props.bankAccount.accountNumber}</td>
                <td>{this.props.bankAccount.IBAN}</td>
                <td>{this.props.bankAccount.bankName}</td>
                <td>{this.props.bankAccount.bic}</td>
            </tr>
        )
    }
}

ReactDOM.render(
    <App />,
    document.getElementById('react')
)
