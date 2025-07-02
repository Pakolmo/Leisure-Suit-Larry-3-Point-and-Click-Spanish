;;; Sierra Script 1.0 - (do not remove this comment)
(script# 989)
(include sci.sh)
(use Main)
(use Obj)


(class Sound of Obj
	(properties
		state $0000
		number 0
		priority 0
		loop 1
		handle 0
		signal $0000
		prevSignal 0
		client 0
		owner 0
	)
	
	(method (new param1)
		((super new:) owner: (if argc param1 else 0) yourself:)
	)
	
	(method (init)
		(= signal 0)
		(= prevSignal 0)
		(= state 0)
		(gSounds add: self)
		(DoSound sndINIT self)
	)
	
	(method (play param1 &tmp temp0)
		(self stop:)
		(if (not loop) (= loop 1))
		(self init:)
		(= client (if argc param1 else 0))
		(DoSound sndPLAY self)
	)
	
	(method (playMaybe)
		(self play: &rest)
		(if (== state 2) (self dispose:))
	)
	
	(method (check)
		(if signal
			(if (IsObject client) (client cue: self))
			(= prevSignal signal)
			(= signal 0)
		)
	)
	
	(method (stop param1)
		(if (and argc (not param1)) (= client 0))
		(if handle (DoSound sndSTOP handle))
	)
	
	(method (dispose param1)
		(if (and argc (not param1)) (= client 0))
		(gSounds delete: self)
		(if handle (DoSound sndDISPOSE handle) (= handle 0))
		(super dispose:)
	)
	
	(method (pause param1)
		(DoSound sndPAUSE param1)
	)
	
	(method (sel_334)
		(gGame sel_333: global196)
		(DoSound sndVOLUME global196)
	)
	
	(method (changeState)
		(DoSound sndUPDATE self)
	)
	
	(method (clean param1)
		(if (or (not owner) (== owner param1))
			(self dispose:)
		)
	)
	
	(method (fade param1)
		(if (and argc (not param1)) (= client 0))
		(DoSound sndFADE handle)
	)
)
