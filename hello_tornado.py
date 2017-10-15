'''
在程序的最顶部，我们导入了一些Tornado模块。
虽然Tornado还有另外一些有用的模块，但在这个例子中我们必须至少包含这四个模块。
'''
import tornado.httpserver
import tornado.ioloop
import tornado.options
import tornado.web

'''
Tornado包括了一个有用的模块（tornado.options）来从命令行中读取设置
'''

from tornado.options import define,options
define("port",default=8000,help="run on the given port",type=int)

class IndexHandle(tornado.web.RequestHandler):
	def get(self):
		greenting = self.get_argument('greenting','Hello')
		self.write(greenting+", friendly user!")

if __name__ == '__main__':
	tornado.options.parse_command_line()
	app = tornado.web.Application(handlers=[(r"/",IndexHandle)])
	http_server = tornado.httpserver.HTTPServer(app)
	http_server.listen(options.port)
	tornado.ioloop.IOLoop.instance().start()