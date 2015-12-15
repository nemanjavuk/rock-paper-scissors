package com.github.nemanjavuk.rps.ui;

import com.github.nemanjavuk.rps.model.PlayCommand;
import com.github.nemanjavuk.rps.model.PlayCommandFactory;

/**
 * Created by nemanja.
 */
public class ComputerPlayer implements Player {

    private PlayCommandFactory playCommandFactory;

    public ComputerPlayer(PlayCommandFactory playCommandFactory) {
        this.playCommandFactory = playCommandFactory;
    }

    @Override
    public PlayCommand nextMove() {
        return playCommandFactory.createRandomPlayCommand();
    }
}
