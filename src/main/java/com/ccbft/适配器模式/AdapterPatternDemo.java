package com.ccbft.适配器模式;

/**
 * 适配器模式是一种常用的设计模式，它可以用于将一些不兼容的接口转换成目标接口。下面是一个实战案例：
 *
 * 假设我们有一个音乐播放器应用程序，其中有两个类AndroidMusicPlayer和iPhoneMusicPlayer分别用于播放Android和iPhone设备上的音乐。
 * 现在我们需要添加一个新的功能，让这两个类都可以播放MP3文件。
 *
 * 适配器模式帮助我们将不兼容的AndroidMusicPlayer和iPhoneMusicPlayer类转换成了符合目标接口的MediaPlayer接口。
 * 通过使用适配器模式，我们可以使这两个类也能够播放MP3文件
 * 并且对于客户端代码而言，它们就像是实现了同一个接口一样，具有相同的行为和功能。
 *
 */
public class AdapterPatternDemo {

    public static void main(String[] args) {
        MediaPlayer mediaPlayer = new MediaAdapter();
        mediaPlayer.play("android", "android_music.mp3");
        mediaPlayer.play("iphone", "iphone_music.mp3");
        mediaPlayer.play("mp3", "mp3_music.mp3");
        mediaPlayer.play("mp4", "mp4_music.mp4");
    }

    interface MediaPlayer {
        void play(String audioType, String fileName);
    }

    static class AndroidMusicPlayer {
        public void playAndroid(String fileName) {
            System.out.println("Playing Android Music. Name: " + fileName);
        }
    }

    static class iPhoneMusicPlayer {
        public void playIPhone(String fileName) {
            System.out.println("Playing iPhone Music. Name: " + fileName);
        }
    }

    static class MediaAdapter implements MediaPlayer {
        private final AndroidMusicPlayer androidMusicPlayer;
        private final iPhoneMusicPlayer iphoneMusicPlayer;

        public MediaAdapter() {
            this.androidMusicPlayer = new AndroidMusicPlayer();
            this.iphoneMusicPlayer = new iPhoneMusicPlayer();
        }

        @Override
        public void play(String audioType, String fileName) {
            if (audioType.equalsIgnoreCase("android")) {
                androidMusicPlayer.playAndroid(fileName);
            } else if (audioType.equalsIgnoreCase("iphone")) {
                iphoneMusicPlayer.playIPhone(fileName);
            } else if (audioType.equalsIgnoreCase("mp3")) {
                System.out.println("Playing MP3 file. Name: " + fileName);
            } else {
                System.out.println("Invalid media. " + audioType + " format not supported");
            }
        }
    }
}