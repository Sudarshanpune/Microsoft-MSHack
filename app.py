from flask import Flask, render_template, url_for, redirect

app = Flask("__app__")
app.config['SECRET_KEY'] = 'a551d32359baf371b9095f28d45347c8b8621830'

@app.route('/')
def home():
	return render_template('index.html')

app.run(debug=True)