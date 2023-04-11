class RemoteControl {
  RemoteControl(this.device);

  final Device device;

  void togglePower() {
    if (device.isEnabled) {
      device.disable();
    } else {
      device.enable();
    }
    print('Device is currently ${device.isEnabled ? 'on' : 'off'}');
  }

  void volumeDown() {
    device.volume = device.volume - 10;
    print('Turn down volume! Current volume is ${device.volume}');
  }

  void volumeUp() {
    device.volume = device.volume + 10;
    print('Turn up volume! Current volume is ${device.volume}');
  }

  void channelDown() {
    device.channel = device.channel - 1;
    print('Turn down channel! Current channel is ${device.channel}');
  }

  void channelUp() {
    device.channel = device.channel + 1;
    print('Turn up channel! Current channel is ${device.channel}');
  }
}

class AdvancedRemoteControl extends RemoteControl {
  AdvancedRemoteControl(super.device);

  void mute() {
    device.volume = 0;
  }
}

abstract class Device {
  bool get isEnabled;

  void enable();

  void disable();

  int get volume;

  set volume(int percent);

  int get channel;

  set channel(int channel);
}

class TV extends Device {
  bool _enable = true;

  @override
  int channel = 10;

  @override
  int volume = 50;

  @override
  void disable() {
    _enable = false;
  }

  @override
  void enable() {
    _enable = true;
  }

  @override
  bool get isEnabled => _enable;
}

void main() {
  final tv = TV();
  final remote = AdvancedRemoteControl(tv);
  remote.togglePower();
  remote.togglePower();
  remote.volumeUp();
  remote.volumeUp();
  remote.volumeUp();
  remote.volumeDown();
  remote.channelDown();
  remote.channelUp();
  remote.channelDown();
}
