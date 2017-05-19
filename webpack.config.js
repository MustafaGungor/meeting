var path = require('path');

module.exports = {
    entry: './src/main/js/main.jsx',
    devtool: 'sourcemaps',
    cache: true,
    debug: true,
    resolve: {
        modules: ["node_modules"],
        extensions: [
            '.js',
            '.jsx',
            '.json'
        ],
        enforceExtension: false
    },
    output: {
        path: __dirname,
        filename: './src/main/resources/static/app.js'
    },
    module: {
        loaders: [
            {
                test: path.join(__dirname, '.'),
                exclude: /(node_modules)/,
                loader: 'babel',
                query: {
                    cacheDirectory: true,
                    presets: ['es2015', 'react']
                }
            }
        ],
        rules:[
            {
                test: /\.s?css$/,
                use: ["style-loader", "css-loader"]
            }
        ]
    }
};