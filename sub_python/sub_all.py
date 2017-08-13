import zmq

context = zmq.Context()

sock = context.socket(zmq.SUB)

sock.setsockopt(zmq.SUBSCRIBE, b"")
sock.connect("tcp://127.0.0.1:8001")
sock.connect("tcp://127.0.0.1:8002")
print('subscriber connected to ports 8001 & 8002');
print('receiving messages...');

try:
    while True:
        message = sock.recv()
        exchange, update = message.split()
        print('exchange: ', exchange.decode(), ' update: ', update.decode());

except KeyboardInterrupt:
    print("Interrupt received, stopping.")
finally:
    # clean up
    sock.close()
    context.term()
