package com.github.nemanjavuk.rps.ui;

import com.github.nemanjavuk.rps.model.PlayCommand;
import com.github.nemanjavuk.rps.model.PlayCommandFactory;
import com.github.nemanjavuk.rps.ui.Player;

/**
 * Created by nemanja on 12/14/15.
 */
public class ComputerPlayer implements Player {

    @Override
    public PlayCommand nextMove() {
        return PlayCommandFactory.createRandomPlayCommand();
    }
}
