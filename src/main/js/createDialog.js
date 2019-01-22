const React = require('react');
const ReactDOM = require('react-dom');
const client = require('./client');
const app = require('./app');

class CreateDialog extends React.Component {

    constructor(props) {
        super(props);
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    handleSubmit(e) {
        e.preventDefault();
        const newBankAccount = {};
        this.props.attributes.forEach(attribute => {
            newBankAccount[attribute] = ReactDOM.findDOMNode(this.refs[attribute]).value.trim();
        });
        this.props.onCreate(newBankAccount);

        // clear out the dialog's inputs
        this.props.attributes.forEach(attribute => {
            ReactDOM.findDOMNode(this.refs[attribute]).value = '';
        });

        // Navigate away from the dialog to hide it.
        window.location = "#";
    }

    render() {
        const inputs = this.props.attributes.map(attribute =>
            <p key={attribute}>
                <input type="text" placeholder={attribute} ref={attribute} className="field"/>
            </p>
        );

        return (
            <div>
                <a href="#createBankAccount">Create</a>

                <div id="createBankAccount" className="modalDialog">
                    <div>
                        <a href="#" title="Close" className="close">X</a>

                        <h2>Create new bank account</h2>

                        <form>
                            {inputs}
                            <button onClick={this.handleSubmit}>Create</button>
                        </form>
                    </div>
                </div>
            </div>
        )
    }

    onCreate(newBankAccount) {
        follow(client, root, ['bankAccounts']).then(bankAccountCollection => {
            return client({
                method: 'POST',
                path: bankAccountCollection.entity._links.self.href,
                entity: newBankAccount,
                headers: {'Content-Type': 'application/json'}
            })
        }).then(response => {
            return follow(client, root, [
                {rel: 'bankAccounts', params: {'size': this.state.pageSize}}]);
        }).done(response => {
            if (typeof response.entity._links.last !== "undefined") {
                app.onNavigate(response.entity._links.last.href);
            } else {
                app.onNavigate(response.entity._links.self.href);
            }
        });
    }

}

