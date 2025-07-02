;;; Sierra Script 1.0 - (do not remove this comment)
(script# 22)
(include sci.sh)
(use Main)
(use Class_255_0)
(use gamefile.sh)
(use Game)
(use User)
(use Obj)

(public
	rm22 0
)

(instance rm22 of Locale
	(properties)
	
	(method (handleEvent pEvent &tmp temp0 [temp1 3] [temp4 30] [temp34 30] [temp64 30])
		(if (or (not (proc0_22 14)) (pEvent claimed?))
			(return)
		)
		(switch (pEvent type?)
			(evKEYBOARD
				(switch (pEvent message?)
					(KEY_ALT_c
						(Show 4)
						(Animate (gCast elements?) 0)
						(while (== 0 ((= pEvent (Event new:)) type?))
							(pEvent dispose:)
						)
						(pEvent dispose:)
						(Show 1)
						(return)
					)
					(KEY_ALT_d (SetDebug))
					(KEY_ALT_i (User canInput: 1))
					(KEY_ALT_m (gGame showMem:))
					(KEY_ALT_n
						(= temp34 0)
						(= temp64 0)
						(= temp0 1)
						(++ global183)
						(while
						(proc255_2 @temp64 40 {Pulsa "Enter" o "ESC" para finalizar.})
							(Format @temp4 22 0 (gGame name?) @global180)
							(Format
								@temp34
								22
								1
								gNumber
								global28
								@global175
								@global180
								global183
								temp0
								(gEgo view?)
								(gEgo x?)
								(gEgo y?)
							)
							(gamefile_sh
								name: @temp4
								write: @temp34 @temp64 {\0D\n}
								close:
							)
							(= temp64 0)
							(++ temp0)
						)
					)
					(KEY_ALT_p (Show 2))
					(KEY_ALT_r
						(proc255_0 (Format @temp4 22 2 gNumber))
					)
					(KEY_ALT_v (Show 1))
					(KEY_ALT_x)
					(KEY_ALT_z (= global4 1))
					(JOY_DOWNRIGHT
						(= temp0 (proc255_3 {Teleport to}))
						(if (Load rsSCRIPT temp0)
							(proc0_1)
							(global2 newRoom: temp0)
						else
							(proc255_0 22 3)
							(SetDebug)
						)
					)
					(JOY_DOWN
						(proc255_0
							(Format
								@temp4
								{view %d loop %d cel %d posn %d %d pri %d OnControl $%x Origin on $%x}
								(gEgo view?)
								(gEgo loop?)
								(gEgo cel?)
								(gEgo x?)
								(gEgo y?)
								(gEgo priority?)
								(gEgo onControl:)
								(gEgo onControl: 1)
							)
							82
							(gEgo view?)
							(gEgo loop?)
							(gEgo cel?)
						)
					)
					(JOY_UPLEFT (gGame showMem:))
				)
			)
			(evSAID
				(if (Said 'tp')
					(= temp0 (proc255_3 {Teleport to}))
					(if (Load rsSCRIPT temp0)
						(proc0_1)
						(global2 newRoom: temp0)
					else
						(proc255_0 22 3)
						(SetDebug)
					)
				)
			)
		)
		(if (not (pEvent claimed?))
			(super handleEvent: pEvent)
		)
	)
)
