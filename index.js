var express = require('express');
var app = express();
require('dotenv').config();



const Telegraf = require('telegraf');
const Extra = require('telegraf/extra')
const Markup = require('telegraf/markup')
const fetch = require('node-fetch')

app.get('/', function(req, res){
    res.send('TESTING Lyrics bot');

});


app.listen(4000,  function(){
    console.log("Testing app listening on port 4000!!")
})


const bot = new Telegraf(process.env.BOT_TOKEN)
/* bot.start((ctx) => ctx.reply('Welcome'))
bot.help((ctx) => ctx.reply('Send me a sticker')) */
bot.on('sticker', (ctx) => ctx.reply('👍'))
bot.hears('/test', (ctx) => ctx.reply('Hey there'))
bot.command('oldschool', (ctx) => ctx.reply('Hello'))
bot.command('modern', ({ reply }) => reply('Yo'))
bot.command('hipster', Telegraf.reply('λ'))
bot.launch()

