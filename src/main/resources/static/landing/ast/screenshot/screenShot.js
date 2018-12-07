const puppeteer = require('puppeteer');

(async()=>{
	const browser = await puppeteer.launch();
	const page = await browser.newPage();
	await page.goto('https://wwww.imooc.com');
	await page.screenshot
}